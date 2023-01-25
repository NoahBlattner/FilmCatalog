package com.divtec.blatnoa.filmcatalog.FilmList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import androidx.loader.content.AsyncTaskLoader;

import com.divtec.blatnoa.filmcatalog.API.OnLoadedAction;

import java.io.IOException;
import java.net.URL;

public class NetworkImageLoader implements Runnable {

    private String url;
    private OnLoadedAction onLoadedAction;

    /**
     * Create a new NetworkImageLoader
     * @param url The url of the image
     * @param onLoadedAction The action to perform when the image is loaded
     */
    public NetworkImageLoader(String url, OnLoadedAction onLoadedAction) {
        this.url = url;
        this.onLoadedAction = onLoadedAction;
        load();
    }

    /**
     * Load the image from the url
     */
    public void load() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            // Load the image from the url
            URL imageUrl = new URL(url);
            Bitmap image = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());
            onLoadedAction.onLoaded(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
