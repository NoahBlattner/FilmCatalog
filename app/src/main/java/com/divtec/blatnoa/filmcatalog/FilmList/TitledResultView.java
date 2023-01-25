package com.divtec.blatnoa.filmcatalog.FilmList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.SearchResult;
import com.divtec.blatnoa.filmcatalog.API.ApiObjects.TitledResult;
import com.divtec.blatnoa.filmcatalog.API.OnLoadedAction;
import com.divtec.blatnoa.filmcatalog.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TitledResultView extends RecyclerView.ViewHolder {
    private TextView resultTitle;
    private ImageView resultImage;

    public TitledResultView(@NonNull View itemView) {
        super(itemView);

        resultTitle = itemView.findViewById(R.id.txt_movie_title);
        resultImage = itemView.findViewById(R.id.img_movie_poster);
    }

    /**
     * Set the data of the view
     * @param titledResult The data to set
     */
    public void setData(TitledResult titledResult) {
        resultTitle.setText(titledResult.getTitle());
        setImage(titledResult.getImage());
    }

    /**
     * Set the image of the view from a url
     * @param url The url of the image
     */
    public void setImage(String url) {
        NetworkImageLoader loader = new NetworkImageLoader(url, new OnLoadedAction() {
            @Override
            public void onLoaded(Object object) {
                Activity activity = (Activity) itemView.getContext();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Bitmap image = (Bitmap) object;
                        resultImage.setImageBitmap(image);
                    }
                });
            }

            @Override
            public void onLoaded(String result) {

            }

            @Override
            public void onLoaded(int result) {

            }
        });
    }
}
