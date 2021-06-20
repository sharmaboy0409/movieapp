package com.digitalmeverick.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class movieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        ImageView imageView= findViewById(R.id.singleViewImage);
        TextView title= findViewById(R.id.title);
        TextView date= findViewById(R.id.date);
        TextView rating= findViewById(R.id.rating);
        TextView desc= findViewById(R.id.desc);

        Bundle bundle= getIntent().getExtras();
        String mTitle=bundle.getString("title");
        String mDesc=bundle.getString("desc");
        String mDate=bundle.getString("date");
        String mPoster=bundle.getString("poster");
        Double mRating=bundle.getDouble("rating");

        Log.d("aaa", "onCreate: "+mPoster);

      //  Glide.with(movieDetail.this).load(mPoster).into(imageView);
        title.setText(mTitle);
        date.setText(mDate);
        rating.setText(mRating.toString());
        desc.setText(mDesc);
        date.setText(mDate);

    }
}