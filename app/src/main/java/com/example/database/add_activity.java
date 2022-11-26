package com.example.database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class add_activity extends AppCompatActivity {

    Button ArtistButton;
    Button TrackButton;
    Button AlbumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);



        ArtistButton = findViewById(R.id.buttonAddArtist);
        TrackButton = findViewById(R.id.buttonAddTrack);
        AlbumButton = findViewById(R.id.buttonAddAlbum);


        View.OnClickListener onClickAddArtist = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f1 = new com.example.database.ArtistFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f1);
                ft.commit();
            }
        };


        View.OnClickListener onClickAddTrack = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f2 = new com.example.database.TrackFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f2);
                ft.commit();

            }
        };



        View.OnClickListener onClickAddAlbum = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f3 = new com.example.database.AlbumFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f3);
                ft.commit();

            }
        };

        ArtistButton.setOnClickListener(onClickAddArtist);
        TrackButton.setOnClickListener(onClickAddTrack);
        AlbumButton.setOnClickListener(onClickAddAlbum);


    }
}
