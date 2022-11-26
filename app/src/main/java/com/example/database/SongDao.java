package com.example.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import kotlinx.coroutines.flow.Flow;

@Dao
public interface SongDao {

    @Query("SELECT * FROM song")
    List<Song> getAll();

    @Query("DELETE FROM song")
    void deleteAll();

    @Insert
    void insert(Song song);

    @Delete
    void delete(Song song);

    //@Query("SELECT song.song_name, artist.artist_name, album.album_name FROM song INNER JOIN Album ON song_album = Album.id INNER JOIN artist ON album_artist = Artist.id")

//    @Query("SELECT song_name, artist.artist_name, album.album_name FROM song INNER JOIN Album ON song_album = Album.id INNER JOIN artist ON album_artist = Artist.id")
//    //@Query("SELECT song_name, song_artist, song_album FROM song INNER JOIN Album ON song_album = Album.id INNER JOIN artist ON album_artist = Artist.id")
//    List<TrackInfo> getInfo();

    @Query("SELECT song.song_name, artist.artist_name, album.album_name FROM song INNER JOIN Album ON song_album = album.id INNER JOIN artist ON album_artist = Artist.id")
    List<TrackInfo> getInfo();




}
