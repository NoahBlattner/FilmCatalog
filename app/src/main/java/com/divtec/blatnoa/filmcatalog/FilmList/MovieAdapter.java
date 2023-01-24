package com.divtec.blatnoa.filmcatalog.FilmList;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieView> {

    private ArrayList<Movie> filmList = new ArrayList<>();

    public MovieAdapter(ArrayList<Movie> filmList) {
        this.filmList = filmList;
    }

    public void addFilm(Movie film) {
        filmList.add(film);
    }

    public void removeFilm(Movie film) {
        filmList.remove(film);
    }

    public void clearFilms() {
        filmList.clear();
    }

    @NonNull
    @Override
    public MovieView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
