package com.divtec.blatnoa.filmcatalog.FilmList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.TitledResult;
import com.divtec.blatnoa.filmcatalog.API.OnLoadedAction;
import com.divtec.blatnoa.filmcatalog.R;
import com.squareup.picasso.Picasso;

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
        setPosterImage(titledResult.getImage());
    }

    /**
     * Set the image of the view from a url
     * @param url The url of the image
     */
    public void setPosterImage(String url) {
        Picasso.get().load(url).resize(400, 600).into(resultImage);
    }
}
