package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity  {

    com.example.database.MyRecyclerViewAdapter adapter;
    Button addButton;
    Button showButton;
    Button deleteButton;
    TextInputEditText findText;


    private com.example.database.DatabaseClient mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findText = findViewById(R.id.findText);

        ArrayList<String> songNames = new ArrayList<>();
        ArrayList<String> songAlbums = new ArrayList<>();
        ArrayList<String> songArtists = new ArrayList<>();



        mDb = com.example.database.DatabaseClient.getInstance(getApplicationContext());
        List<TrackInfo> songs = mDb.getAppDatabase().songDao().getInfo();
        for(int i = 0; i < songs.size(); ++i){
            songNames.add(songs.get(i).getSongName());
            songAlbums.add(songs.get(i).getSongAlbum());
            songArtists.add(songs.get(i).getSongArtist());
        }


        RecyclerView recyclerView = findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new com.example.database.MyRecyclerViewAdapter(this, songNames, songAlbums, songArtists);

        recyclerView.setAdapter(adapter);


        addButton = findViewById(R.id.addbutton);
        View.OnClickListener onClickAddButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this, com.example.database.add_activity.class);
                startActivity(myintent);

            }
        };
        addButton.setOnClickListener(onClickAddButton);

        showButton = findViewById(R.id.buttonShow);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                songNames.clear();
                songAlbums.clear();
                songArtists.clear();

                String s = findText.getText().toString();
                List<TrackInfo> songs = mDb.getAppDatabase().songDao().getInfo();
                if (s != "" && s.length() != 0){
                    for(int i = 0; i <songs.size(); ++i){
                        //String sn = songs.get(i).getSongName();
                        if (songs.get(i).getSongName().equals(s)){
                            songNames.add(songs.get(i).getSongName());
                            songAlbums.add(songs.get(i).getSongAlbum());
                            songArtists.add(songs.get(i).getSongArtist());
                            adapter.notifyDataSetChanged();
                        }
                    }
                }

                else {


                    for (int i = 0; i < songs.size(); ++i) {
                        TrackInfo current = songs.get(i);
                        songNames.add(i, current.getSongName());
                        songAlbums.add(i, current.getSongAlbum());
                        songArtists.add(i, current.getSongArtist());
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        deleteButton = findViewById(R.id.deletebutton);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDb.getAppDatabase().songDao().deleteAll();
                mDb.getAppDatabase().albumDao().deleteAll();
                mDb.getAppDatabase().artistDao().deleteAll();
                adapter.notifyItemRangeRemoved(0, songNames.size());
                songNames.clear();
                songAlbums.clear();
                songArtists.clear();
            }
        });


    }



}