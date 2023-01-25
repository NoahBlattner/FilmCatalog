package com.divtec.blatnoa.filmcatalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.ApiKeyInfo;
import com.divtec.blatnoa.filmcatalog.API.ApiObjects.SearchResult;
import com.divtec.blatnoa.filmcatalog.API.ApiObjects.TitledResult;
import com.divtec.blatnoa.filmcatalog.API.Exceptions.ApiErrorException;
import com.divtec.blatnoa.filmcatalog.API.ImdbApiManager;
import com.divtec.blatnoa.filmcatalog.API.OnLoadedAction;
import com.divtec.blatnoa.filmcatalog.FilmList.TitledResultAdapter;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String API_KEY = "k_ad1lydac";

    private EditText editFilter;
    private Button btnSearch;

    private RecyclerView recyclerView;
    private ImdbApiManager imdbApiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get views
        recyclerView = findViewById(R.id.rv_list_movie);
        editFilter = findViewById(R.id.edit_filter_input);
        btnSearch = findViewById(R.id.btn_search);

        // Get api manager
        imdbApiManager = ImdbApiManager.createInstance(this, API_KEY);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the filter
                String filter = editFilter.getText().toString();

                if (filter.isEmpty()) {
                    // Load the top 250 movies
                    loadTop250Movies();
                } else {
                    // Load the movies with the given filter
                    loadMoviesWithParams(filter);
                }
            }
        });

        // Verify the api key
        loadTop250IfApiKeyOK();
    }

    /**
     * Check if the api key is ok
     * If not, show an error message
     */
    private void loadTop250IfApiKeyOK() {
        try {
            imdbApiManager.loadApiKeyInfo(new OnLoadedAction() {
                @Override
                public void onLoaded(Object result) {
                    // Get the api key info
                    ApiKeyInfo apiKeyInfo = (ApiKeyInfo) result;

                    if (apiKeyInfo.isOk()) {
                        // Load the top 250 movies
                        loadTop250Movies();
                    } else {
                        showApiKeyErrorMessage(apiKeyInfo);
                    }
                }
            });
        } catch (ApiErrorException e) {
            e.printStackTrace();
            showErrorDialog(e.getMessage());
        }
    }

    /**
     * Load the top 250 movies into the recycler view
     */
    private void loadTop250Movies() {
        // Try to load the top 250 movies
        try {
            imdbApiManager.loadTop250Movies(new OnLoadedAction() {
                @Override
                public void onLoaded(Object result) {
                    // Get the list of movies
                    ArrayList<TitledResult> movieList = (ArrayList<TitledResult>) result;
                    TitledResultAdapter movieAdapter = new TitledResultAdapter(movieList);

                    // Set the adapter to the recycler view
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(movieAdapter);
                }
            });
        } catch (ApiErrorException e) {
            e.printStackTrace();
            showErrorDialog(e.getMessage());
        }
    }

    /**
     * Load the movies with the given filter into the recycler view
     * @param filter The filter to use
     */
    private void loadMoviesWithParams(String filter) {
        // Try to load the movies
        try {
            imdbApiManager.loadMovies(filter, new OnLoadedAction() {
                @Override
                public void onLoaded(Object result) {
                    // Get the list of movies
                    ArrayList<SearchResult> movieList = (ArrayList<SearchResult>) result;
                    TitledResultAdapter movieAdapter = new TitledResultAdapter(new ArrayList<>(movieList));

                    // Set the adapter to the recycler view
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(movieAdapter);
                }
            });
        } catch (ApiErrorException e) {
            e.printStackTrace();
            showErrorDialog(e.getMessage());
        }
    }

    /**
     * Show an error dialog with the given message
     * @param message The message to show
     */
    private void showErrorDialog(String message) {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Error")
                .setMessage(message + "\nCheck your internet connection and try again.")
                .setPositiveButton("OK", null)
                .show();
    }

    /**
     * Show an error message if the api key is not ok
     * @param apiKeyInfo The api key info
     */
    private void showApiKeyErrorMessage(ApiKeyInfo apiKeyInfo) {
        String message;

        // Get the error message
        if (apiKeyInfo.isExceeded()) {
            message = "The api key has exceeded the limit of requests";
        } else if (apiKeyInfo.isExpired()){
            message = "The api key has expired";
        } else{
            message = "An unknown error has occurred with the api key";
        }

        message += "\nError : " + apiKeyInfo.getErrorMessage();

        // Show the error message dialog
        new MaterialAlertDialogBuilder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton("Ok", null)
                .show();
    }
}