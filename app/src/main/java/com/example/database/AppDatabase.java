package com.example.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.database.Song.class, com.example.database.Artist.class, Album.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract com.example.database.SongDao songDao();
    public abstract com.example.database.ArtistDao artistDao();
    public abstract AlbumDao albumDao();

}
