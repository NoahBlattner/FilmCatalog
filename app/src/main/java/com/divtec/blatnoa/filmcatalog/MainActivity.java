package com.divtec.blatnoa.filmcatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.SearchResult;
import com.divtec.blatnoa.filmcatalog.API.Exceptions.ApiErrorException;
import com.divtec.blatnoa.filmcatalog.API.ImdbApiManager;
import com.divtec.blatnoa.filmcatalog.API.OnLoadedAction;
import com.divtec.blatnoa.filmcatalog.FilmList.SearchResultAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "k_ad1lydac";

    private RecyclerView recyclerView;
    private ImdbApiManager imdbApiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get views
        recyclerView = findViewById(R.id.rv_list_movie);

        // Get api manager
        imdbApiManager = ImdbApiManager.createInstance(this, API_KEY);

        // Try to load the top 250 movies
        try {
            imdbApiManager.loadTop250Movies(new OnLoadedAction() {
                @Override
                public void onLoaded(Object result) {
                    // Get the list of movies
                    ArrayList<SearchResult> movieList = (ArrayList<SearchResult>) result;
                    SearchResultAdapter movieAdapter = new SearchResultAdapter(movieList);

                    // Set the adapter to the recycler view
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(movieAdapter);
                }

                @Override
                public void onLoaded(String result) {

                }

                @Override
                public void onLoaded(int result) {

                }
            });
        } catch (ApiErrorException e) {
            e.printStackTrace();
        }
    }
}