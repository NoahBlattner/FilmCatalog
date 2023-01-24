package com.divtec.blatnoa.filmcatalog.API;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.divtec.blatnoa.filmcatalog.API.ApiObjects.ApiObjectBuilder;
import com.divtec.blatnoa.filmcatalog.API.ApiObjects.Movie;
import com.divtec.blatnoa.filmcatalog.API.Exceptions.ApiError401Exception;
import com.divtec.blatnoa.filmcatalog.API.Exceptions.ApiError404Exception;
import com.divtec.blatnoa.filmcatalog.API.Exceptions.ApiError408Exception;
import com.divtec.blatnoa.filmcatalog.API.Exceptions.ApiErrorException;
import com.divtec.blatnoa.filmcatalog.API.Exceptions.UnknownApiErrorException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ImdbApiManager {

    private final String baseUrl = "https://imdb-api.com/";

    private static ImdbApiManager instance;

    private RequestQueue queue;

    private String language;
    private String apiKey;

    private ImdbApiManager(Context context, String apiKey, String language) {
        queue = Volley.newRequestQueue(context);
        this.apiKey = apiKey;
        this.language = language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Loads the top 250 movies from Imdb APi
     * @param onLoadedAction The action to be executed when the movies are loaded
     * @throws ApiError401Exception If the api key is invalid
     * @throws ApiError404Exception If the api path is not found
     * @throws UnknownApiErrorException If the api returns an unknown error
     * @throws ApiError408Exception If the api request timed out
     */
    public void loadMovies(OnLoadedAction onLoadedAction) throws ApiError401Exception, ApiError404Exception, UnknownApiErrorException, ApiError408Exception {
        String url = getFullUrl("SearchMovie", "");
        // TODO find right action to get x movies

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Get the JSON array
                            JSONArray moviesJson = response.getJSONArray("items");
                            ArrayList<Movie> movies = new ArrayList<>();

                            for (int i = 0; i < moviesJson.length(); i++) {
                                try {
                                    // Convert each JSON object to a Movie object and add it to the list
                                    Movie movie = ApiObjectBuilder.fromJson(moviesJson.getJSONObject(i).toString(), Movie.class);
                                    movies.add(movie);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            // Execute the action
                            onLoadedAction.onLoaded(movies);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        handleError(error, url);
                    }
                });

        // Add the request to the queue
        queue.add(request);
    }

    /**
     * Handle an error from the api
     * @param error The error
     * @param url The url that caused the error
     */
    private void handleError(VolleyError error, String url) throws ApiErrorException {
        if (error.networkResponse == null) {
            throw new UnknownApiErrorException(url);
        }

        switch (error.networkResponse.statusCode) {
            case 401:
                throw new ApiError401Exception(url);
            case 404:
                throw new ApiError404Exception(url);
            case 408:
                throw new ApiError408Exception(url);
            default:
                throw new UnknownApiErrorException(url);
        }
    }

    private String getFullUrl(String action, String parameters) {
        // Remove slashes from action and parameters
        action = action.replace("/", "");
        parameters = parameters.replace("/", "");

        // Build url
        String url = baseUrl + language + "/API/" + action + "/" + apiKey;
        if (!parameters.isEmpty()) {
            url += "/" + parameters;
        }

        return url;
    }

    /*
    *  Singleton functions
     */
    public static ImdbApiManager createInstance(Context context, String apiKey) {
        instance = new ImdbApiManager(context, apiKey, "en");
        return instance;
    }

    public static ImdbApiManager createInstance(Context context, String apiKey, String language) {
        instance = new ImdbApiManager(context, apiKey, language);
        return instance;
    }

    public static ImdbApiManager getInstance() {
        return instance;
    }

    public static void destroyInstance() {
        instance.queue.stop();
        instance = null;
    }
}
