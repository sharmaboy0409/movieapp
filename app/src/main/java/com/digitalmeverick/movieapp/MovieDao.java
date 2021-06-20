package com.digitalmeverick.movieapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM MovieTable" )
    List<MovieModel> getAllMovies();

    @Query("SELECT * FROM MovieTable ORDER BY date " )
    List<MovieModel> getAllMoviesbyrating();


    @Insert(onConflict = REPLACE)
    void insertMovie(Movieofline movieoflines);
}
