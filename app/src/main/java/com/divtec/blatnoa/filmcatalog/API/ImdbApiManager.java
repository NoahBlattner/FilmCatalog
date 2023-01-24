package com.divtec.blatnoa.filmcatalog.API;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

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

    public ArrayList<Movie> getMovies() throws ApiError401Exception, ApiError404Exception, UnknownApiErrorException, ApiError408Exception{
        String url = getFullUrl("SearchMovie", "");
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // TODO: Parse response
                        String json = response.toString();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        handleError(error, url);
                    }
                });

        return null;
    }

    private void handleError(VolleyError error, String url) throws ApiErrorException {
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
        action = action.replace("/", "");
        return baseUrl + language + "/" + action + "/" + apiKey + "/" + parameters;
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
