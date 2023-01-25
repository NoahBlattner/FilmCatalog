package com.divtec.blatnoa.filmcatalog.FilmList;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.SearchResult;
import com.divtec.blatnoa.filmcatalog.API.ApiObjects.TitledResult;
import com.divtec.blatnoa.filmcatalog.R;

public class TitledResultView extends RecyclerView.ViewHolder {
    private TextView resultTitle;
    private ImageView resultImage;

    public TitledResultView(@NonNull View itemView) {
        super(itemView);

        resultTitle = itemView.findViewById(R.id.txt_movie_title);
        resultImage = itemView.findViewById(R.id.img_movie_poster);
    }

    public void setData(TitledResult titledResult) {
        resultTitle.setText(titledResult.getTitle());
        System.out.println(titledResult.getImage());
    }
}
