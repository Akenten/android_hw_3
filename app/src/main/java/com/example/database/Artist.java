package com.example.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

@Entity
public class Artist {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "artist_name")
    private String artistName;


    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
