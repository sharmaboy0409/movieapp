package com.digitalmeverick.movieapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private List<Movieofline> movieList;

    public MovieAdapter(Context context, List<Movieofline> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.singleview,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movieofline movieModel=movieList.get(position);
       holder.rating.setText( String.valueOf(movieModel.getVote_average()));
        holder.title.setText(movieModel.getTitleR());
        holder.date.setText(movieModel.getDateR());
//        holder.desc.setText(movieModel.getDescR());

        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+movieModel.getPosterR()).into(holder.imageView);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(context,movieDetail.class);

                Bundle bundle= new Bundle();
                bundle.putString("title",movieModel.getTitleR());
                bundle.putString("desc",movieModel.getDescR());
                bundle.putString("date",movieModel.getDateR());
                bundle.putString("poster","https://image.tmdb.org/t/p/w500"+movieModel.getPosterR());
                bundle.putDouble("rating",movieModel.getVote_average());

                intent.putExtras(bundle);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title,date,desc,rating;
        ConstraintLayout constraintLayout;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.singleViewImage);
            title=itemView.findViewById(R.id.moviename);
            date=itemView.findViewById(R.id.date);
            desc=itemView.findViewById(R.id.desc);
            rating=itemView.findViewById(R.id.rating);
            constraintLayout=itemView.findViewById(R.id.singleMovieLayout);
        }
    }
}
