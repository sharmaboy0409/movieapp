package com.digitalmeverick.movieapp;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class MovieModel implements Parcelable {


    @SerializedName("release_date")
    private String release_date;
    @SerializedName("overview")
    private String  overview;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("movie_id")
    private int movie_id;
    @SerializedName("vote_average")
    private double vote_average;
    MovieModel(){

    }

    public MovieModel(String release_date, String overview, String poster_path, String original_title, int movie_id, double vote_average) {
        this.release_date = release_date;
        this.overview = overview;
        this.poster_path = poster_path;
        this.original_title = original_title;
        this.movie_id = movie_id;
        this.vote_average = vote_average;
    }

    protected MovieModel(Parcel in) {
        release_date = in.readString();
        overview = in.readString();
        poster_path = in.readString();
        original_title = in.readString();
        movie_id = in.readInt();
        vote_average = in.readFloat();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public String getRelease_date() {
        return release_date;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(release_date);
        dest.writeString(overview);
        dest.writeString(poster_path);
        dest.writeString(original_title);
        dest.writeInt(movie_id);
        dest.writeDouble(vote_average);
    }
}
