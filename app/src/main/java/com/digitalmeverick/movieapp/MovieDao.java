package com.digitalmeverick.movieapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM MovieTable")
    List<Movieofline> getAllMovies();

    @Query("SELECT * FROM MovieTable ORDER BY date ")
    List<Movieofline> getAllMoviesbyrating();


    @Insert()
    void insertMovie(Movieofline movieoflines);

    @Delete
    public void DeleteMovie(Movieofline movieoflines);

}
