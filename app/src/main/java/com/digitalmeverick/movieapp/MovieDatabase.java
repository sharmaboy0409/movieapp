package com.digitalmeverick.movieapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Movieofline.class},version = 4)//appdatabase
public abstract class MovieDatabase extends RoomDatabase  {


    private  static MovieDatabase INSTANCE;

  //  public migration_3_4=new Migration(3,4)

    public  static Migration migration3_4= new Migration(3,4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE MovieTable ADD COLUMN new_column INTEGER NOT NULL");
        }
    };

    public synchronized   static  MovieDatabase getDbinstance(Context context){
        if ( INSTANCE==null){
           INSTANCE = Room.databaseBuilder(context.getApplicationContext(),MovieDatabase.class,"movietable")
           .allowMainThreadQueries()
                   .fallbackToDestructiveMigration()
                   .addMigrations(migration3_4)
           .build();
        }

        return INSTANCE;

    }

   public   abstract    MovieDao movieDao();

}
