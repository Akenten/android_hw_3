package com.example.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(entity = Artist.class,
                        parentColumns = "id",
                        childColumns = "song_artist",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE),
                @ForeignKey(entity = Album.class,
                parentColumns = "id",
                childColumns = "song_album",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)
        }

)
public class Song {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "song_name")

    private String songName;


    @ColumnInfo(name = "song_artist", index = true)
    private int songArtist;

    @ColumnInfo(name = "song_album", index = true)
    private int songAlbum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSongAlbum() {
        return songAlbum;
    }

    public int getSongArtist() {
        return songArtist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongAlbum(int songAlbum) {
        this.songAlbum = songAlbum;
    }

    public void setSongArtist(int songArtist) {
        this.songArtist = songArtist;
    }


    public void setSongName(String songName) {
        this.songName = songName;
    }

}
