package com.example.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(entity = Artist.class,
                        parentColumns = "id",
                        childColumns = "album_artist",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)
        }
)
public class Album {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "album_name")
    private String albumName;

    @ColumnInfo(name = "album_artist", index = true)
    private int albumArtist;

    @ColumnInfo(name = "album_year")
    private String albumYear;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(int albumArtist) {
        this.albumArtist = albumArtist;
    }

    public String getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(String albumYear) {
        this.albumYear = albumYear;
    }

}
