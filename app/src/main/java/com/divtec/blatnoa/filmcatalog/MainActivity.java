package com.divtec.blatnoa.filmcatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.Movie;
import com.divtec.blatnoa.filmcatalog.API.ImdbApiManager;
import com.divtec.blatnoa.filmcatalog.FilmList.MovieAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "k_ad1lydac";

    private RecyclerView recyclerView;
    private ImdbApiManager imdbApiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_list_movie);

        imdbApiManager = ImdbApiManager.createInstance(this, API_KEY);
        recyclerView.setAdapter(new MovieAdapter(imdbApiManager.getMovies()));
    }
}