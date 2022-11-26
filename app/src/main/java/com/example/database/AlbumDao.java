package com.example.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AlbumDao {

    @Query("SELECT * FROM album")
    List<Album> getAll();

    @Insert
    void insert(Album album);

    @Delete
    void delete(Album album);

    @Query("SELECT id FROM album where album_name = :f")
    int find (String f);

    @Query("DELETE FROM album")
    void deleteAll();

}
