package com.example.database;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;



public class ArtistFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private DatabaseClient mDb;
    TextInputEditText ArtistNameText;
    Button ButtonAddArtist;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_artist, container, false);

        ArtistNameText =  RootView.findViewById(R.id.textInputArtistName);
        ButtonAddArtist =  RootView.findViewById(R.id.buttonSaveArtist);

        mDb = DatabaseClient.getInstance(getContext());

        ButtonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("tag","cliked!");
                Artist artist = new Artist();
                artist.setArtistName(ArtistNameText.getText().toString());

                mDb.getAppDatabase().artistDao().insert(artist);

                Toast.makeText(getContext(), "success", Toast.LENGTH_LONG).show();

            }
        });

        return RootView;
    }

 }