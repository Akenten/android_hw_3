package com.example.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArtistDao {

    @Query("SELECT * FROM artist")
    List<Artist> getAll();

    @Insert
    void insert(Artist artist);

    @Delete
    void delete(Artist artist);

    @Query("SELECT id FROM artist where artist_name = :f")
    int find(String f);

    @Query("DELETE FROM artist")
    void deleteAll();


}
