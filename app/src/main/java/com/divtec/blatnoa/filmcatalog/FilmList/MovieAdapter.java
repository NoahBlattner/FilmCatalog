package com.divtec.blatnoa.filmcatalog.FilmList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.Movie;
import com.divtec.blatnoa.filmcatalog.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieView> {

    private ArrayList<Movie> movieList = new ArrayList<>();

    public MovieAdapter(ArrayList<Movie> filmList) {
        this.movieList = filmList;
    }

    public void addFilm(Movie film) {
        movieList.add(film);
    }

    public void removeFilm(Movie film) {
        movieList.remove(film);
    }

    public void clearFilms() {
        movieList.clear();
    }

    @NonNull
    @Override
    public MovieView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new ranking view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout, parent, false);
        return new MovieView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieView holder, int position) {
        // Get the ranking
        Movie movie = movieList.get(position);

        // Set the ranking data to the view
        holder.setData(movie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
