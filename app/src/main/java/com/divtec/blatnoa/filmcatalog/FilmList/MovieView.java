package com.divtec.blatnoa.filmcatalog.FilmList;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.Movie;
import com.divtec.blatnoa.filmcatalog.R;

public class MovieView extends RecyclerView.ViewHolder {
    private TextView movieTitle;
    private ImageView moviePoster;

    public MovieView(@NonNull View itemView) {
        super(itemView);

        movieTitle = itemView.findViewById(R.id.txt_movie_title);
        moviePoster = itemView.findViewById(R.id.img_movie_poster);
    }

    public void setData(Movie movie) {
        movieTitle.setText(movie.getTitle());
        System.out.println(movie.getImage());
    }
}
