package com.divtec.blatnoa.filmcatalog.FilmList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.SearchResult;
import com.divtec.blatnoa.filmcatalog.API.ApiObjects.TitledResult;
import com.divtec.blatnoa.filmcatalog.R;

import java.util.ArrayList;

public class TitledResultAdapter extends RecyclerView.Adapter<TitledResultView> {

    private ArrayList<TitledResult> searchResultList = new ArrayList<>();

    public TitledResultAdapter(ArrayList<TitledResult> titledResults) {
        this.searchResultList = titledResults;
    }

    @NonNull
    @Override
    public TitledResultView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new ranking view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_layout, parent, false);
        return new TitledResultView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TitledResultView holder, int position) {
        // Get the ranking
        TitledResult titledResult = searchResultList.get(position);

        // Set the ranking data to the view
        holder.setData(titledResult);
    }

    @Override
    public int getItemCount() {
        return searchResultList.size();
    }
}
