package com.example.database;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;



public class AlbumFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private DatabaseClient mDb;
    TextInputEditText AlbumNameText;
    TextInputEditText AlbumArtistText;
    TextInputEditText AlbumYearText;
    Button ButtonAddAlbum;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View RootView = inflater.inflate(R.layout.fragment_album, container, false);

        AlbumNameText = RootView.findViewById(R.id.textInputAlbumName);
        AlbumArtistText = RootView.findViewById(R.id.textInputAlbumArtist);
        AlbumYearText = RootView.findViewById(R.id.textInputAlbumYear);
        ButtonAddAlbum = RootView.findViewById(R.id.buttonSaveAlbum);
        mDb = DatabaseClient.getInstance(getContext());


        ButtonAddAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Album album = new Album();
                album.setAlbumName(AlbumNameText.getText().toString());
                album.setAlbumYear(AlbumYearText.getText().toString());

                int artistId = mDb.getAppDatabase().artistDao().find(AlbumArtistText.getText().toString());

                if(artistId == 0) {
                    Toast.makeText(getContext(), "no such artist, album will not be created", Toast.LENGTH_LONG).show();
                }
                else {
                    album.setAlbumArtist(artistId);
                    mDb.getAppDatabase().albumDao().insert(album);
                    Toast.makeText(getContext(), "success", Toast.LENGTH_LONG).show();

                }

            }
        });

        return RootView;
    }

}