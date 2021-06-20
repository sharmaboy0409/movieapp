package com.digitalmeverick.movieapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Movieofline.class},version = 3)//appdatabase
public abstract class MovieDatabase extends RoomDatabase  {


    private  static MovieDatabase INSTANCE;

    public synchronized   static  MovieDatabase getDbinstance(Context context){
        if ( INSTANCE==null){
           INSTANCE = Room.databaseBuilder(context.getApplicationContext(),MovieDatabase.class,"movietable")
           .allowMainThreadQueries()
                   .fallbackToDestructiveMigration()
           .build();
        }

        return INSTANCE;

    }

   public   abstract    MovieDao movieDao();

}
