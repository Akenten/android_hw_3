package com.example.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;


@Entity(
        tableName = "songInfo",
        primaryKeys = {"song_name", "song_artist"},
        foreignKeys = {
                @ForeignKey(entity = Song.class,
                parentColumns = "song_name",
                childColumns = "song_name",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE),

                @ForeignKey(entity = Artist.class,
                parentColumns = "artist_name",
                childColumns = "song_artist",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE),

                @ForeignKey(entity = Album.class,
                parentColumns = "album_name",
                childColumns = "song_album",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)
        }

)
public class TrackInfo {
    @ColumnInfo(name = "song_name")
    private String songName;
    @ColumnInfo(name = "album_name")
    private String songAlbum;
    @ColumnInfo(name = "artist_name")
    private String songArtist;


    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

}