package com.example.database;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import kotlinx.coroutines.flow.Flow;


public class TrackFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private DatabaseClient mDb;
    TextInputEditText TrackNameText;
    TextInputEditText TrackArtistText;
    TextInputEditText TrackAlbumText;
    Button ButtonAddTrack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_track, container, false);

        TrackNameText = RootView.findViewById(R.id.textInputTrackName);
        TrackArtistText = RootView.findViewById(R.id.textInputTrackArtist);
        TrackAlbumText = RootView.findViewById(R.id.textInputTrackAlbum);
        ButtonAddTrack = RootView.findViewById(R.id.buttonSaveTrack);

        mDb = DatabaseClient.getInstance(getContext());


        ButtonAddTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Song song = new Song();
                song.setSongName(TrackNameText.getText().toString());
                String artist = TrackArtistText.getText().toString();

                int artistId = mDb.getAppDatabase().artistDao().find(artist);
                if (artistId == 0){
                    Toast.makeText(getContext(), "No such artist", Toast.LENGTH_LONG).show();
                }

                String album = TrackAlbumText.getText().toString();

                int albumId = mDb.getAppDatabase().albumDao().find(album);
                if (albumId == 0){
                    Toast.makeText(getContext(), "no such album", Toast.LENGTH_LONG).show();
                }

                song.setSongArtist(artistId);
                song.setSongAlbum(albumId);

                if (albumId != 0 && artistId != 0){
                    mDb.getAppDatabase().songDao().insert(song);
                    Toast.makeText(getContext(), "success", Toast.LENGTH_LONG).show();

                }

            }
        });




        return RootView;
    }
}