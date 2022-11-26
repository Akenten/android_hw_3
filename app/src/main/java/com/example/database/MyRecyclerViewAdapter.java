package com.example.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<String> songName;
    private List<String> songAlbum;
    private List<String> songArtist;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<String> songName, List<String> songAlbum, List<String> songArtist) {
        this.mInflater = LayoutInflater.from(context);
        this.songName = songName;
        this.songAlbum = songAlbum;
        this.songArtist = songArtist;

    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = songName.get(position);
        holder.songtext.setText(name);
        String album = songAlbum.get(position);
        holder.albumtext.setText(album);
        String artist = songArtist.get(position);
        holder.artisttext.setText(artist);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return songName.size();
    }


    // stores and recycles views as they are scrolled off screen

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView songtext;
        TextView albumtext;
        TextView artisttext;

        ViewHolder(View itemView) {
            super(itemView);
            songtext = itemView.findViewById(R.id.rvSongName);
            albumtext = itemView.findViewById(R.id.rvSongAlbum);
            artisttext = itemView.findViewById(R.id.rvSongArtist);


        }

    }


}