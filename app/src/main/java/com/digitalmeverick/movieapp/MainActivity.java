package com.digitalmeverick.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<MovieModel> movieList;
    List <Movieofline> movielist1;
    Button b1,b2;
    MovieDatabase db;

    public  static String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=3b1cdaeccd015d1abbfacb08e85ec570";
    String Apikey="3b1cdaeccd015d1abbfacb08e85ec570";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= MovieDatabase.getDbinstance(this.getApplicationContext());


        new Thread(new Runnable() {
            @Override
            public void run() {


            }
        }).start();

        recyclerView = findViewById(R.id.mainrecview);

        b1= findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        movieList= new ArrayList<>();
        movielist1=new ArrayList<>();


       // Movieofline movieofline= new Movieofline();
        //db.movieDao().DeleteMovie(movieofline);


        getmovie();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMovie();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadMovie2();
            }
        });








    }

    private void getmovie() {

        RequestQueue queue=  Volley.newRequestQueue(this);
         JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
             @Override
             public void onResponse(JSONObject response) {

                 try {
                     JSONArray array= response.getJSONArray("results");

                     for(int i=0;i<array.length();i++){
                         JSONObject movie=array.getJSONObject(i);

                        /* MovieModel model= new MovieModel();
                         model.setOriginal_title(movie.getString("original_title"));
                         model.setOverview(movie.getString("overview"));
                         model.setMovie_id(movie.getInt("id"));
                         model.setRelease_date(movie.getString("release_date"));
                         model.setVote_average(movie.getDouble("vote_average"));
                        // model.setPoster_path(movie.getString("poster_path"));
                         movieList.add(model);*/

                        // Movieofline movieofline= new Movieofline();


                          Movieofline movieDetail= new Movieofline();
                         movieDetail.setTitleR(movie.getString("original_title"));
                         movieDetail.setDateR(movie.getString("release_date"));
                         movieDetail.setDescR(movie.getString("overview"));
                         movieDetail.setPosterR(movie.getString("poster_path"));
                         movieDetail.setVote_average(movie.getDouble("vote_average"));
                         movieDetail.setMovie_id(movie.getInt("id"));
                         db.movieDao().DeleteMovie(movieDetail);
                         db.movieDao().insertMovie(movieDetail);
                        // movieList.add(movieDetail)

                     }
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }
                 //loadMovie();
                 recyclerView.setHasFixedSize(true);
                 recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                // MovieAdapter adapter= new MovieAdapter(getApplicationContext(),movieList);
                 //`recyclerView.setAdapter(adapter);
             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {

                 Toast.makeText(MainActivity.this,"hhh"+error,Toast.LENGTH_LONG).show();
             }
         });

         queue.add(jsonObjectRequest);
    }

    private void saveMovie(String TITLE,String DATE,String DESC,String POSTER,Double VOTE){


      /*  Movieofline movieDetail= new Movieofline();
        movieDetail.title=TITLE;
        movieDetail.date=DATE;
        movieDetail.desc=DESC;
        movieDetail.poster=POSTER;
        movieDetail.rating=VOTE;
        db.movieDao().insertMovie(movieDetail);
         model.setOverview(movie.getString("overview"));
           model.setMovie_id(movie.getInt("id"));
           model.setRelease_date(movie.getString("release_date"));
           model.setVote_average(movie.getDouble("vote_average"));
           model.setPoster_path(movie.getString("poster_path"));
        */

    }

   private void loadMovie(){

        movieList.clear();
       MovieDatabase db = MovieDatabase.getDbinstance(this.getApplicationContext());
       List <Movieofline> movielist1=db.movieDao().getAllMovies();


       for (int i=0;i <movielist1.size();i++){
           MovieModel model= new MovieModel();
           model.setOriginal_title(movielist1.get(i).getTitleR());
           model.setOverview(movielist1.get(i).getDescR());
           model.setMovie_id(movielist1.get(i).getMovie_id());
           model.setRelease_date(movielist1.get(i).getDateR());
           model.setVote_average(movielist1.get(i).getVote_average());
           model.setPoster_path(movielist1.get(i).getPosterR());
           movieList.add(model);
       }

       recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
       MovieAdapter adapter= new MovieAdapter(getApplicationContext(),movielist1);
       recyclerView.setAdapter(adapter);



    }
    private void loadMovie2(){

       movieList.clear();

        MovieDatabase db = MovieDatabase.getDbinstance(this.getApplicationContext());
        List <Movieofline> movielist1=db.movieDao().getAllMoviesbyrating();


        for (int i=0;i <movielist1.size();i++){

            MovieModel model= new MovieModel();
            model.setOriginal_title(movielist1.get(i).getTitleR());
            model.setOverview(movielist1.get(i).getDescR());
            model.setMovie_id(movielist1.get(i).getMovie_id());
            model.setRelease_date(movielist1.get(i).getDateR());
            model.setVote_average(movielist1.get(i).getVote_average());
            model.setPoster_path(movielist1.get(i).getPosterR());
            movieList.add(model);

        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        MovieAdapter adapter= new MovieAdapter(getApplicationContext(),movielist1);
        recyclerView.setAdapter(adapter);
        Log.d("aaa", "loadMovie: "+movielist1.toString());


    }
}