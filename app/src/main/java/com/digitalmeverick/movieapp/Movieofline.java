package com.digitalmeverick.movieapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "MovieTable")//user
public class Movieofline implements Serializable {
    @PrimaryKey (autoGenerate = true)
   public int id;
    @ColumnInfo(name="title")
    public String titleR;
   @ColumnInfo(name="date")
    public String dateR;
    @ColumnInfo(name="vote_average")
    public Double vote_average;
    @ColumnInfo(name="desc")
    public String descR;
    @ColumnInfo(name="poster")
    public String posterR;
    @ColumnInfo(name="movie_id")
    public int movie_id;
    @ColumnInfo(name="new_column")
    public int new_column;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleR() {
        return titleR;
    }

    public void setTitleR(String titleR) {
        this.titleR = titleR;
    }

    public String getDateR() {
        return dateR;
    }

    public void setDateR(String dateR) {
        this.dateR = dateR;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getDescR() {
        return descR;
    }

    public void setDescR(String descR) {
        this.descR = descR;
    }

    public String getPosterR() {
        return posterR;
    }

    public void setPosterR(String posterR) {
        this.posterR = posterR;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }
}
