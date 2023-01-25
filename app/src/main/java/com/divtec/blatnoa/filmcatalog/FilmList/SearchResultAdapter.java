package com.divtec.blatnoa.filmcatalog.FilmList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divtec.blatnoa.filmcatalog.API.ApiObjects.SearchResult;
import com.divtec.blatnoa.filmcatalog.R;

import java.util.ArrayList;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultView> {

    private ArrayList<SearchResult> searchResultList = new ArrayList<>();

    public SearchResultAdapter(ArrayList<SearchResult> filmList) {
        this.searchResultList = filmList;
    }

    @NonNull
    @Override
    public SearchResultView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new ranking view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_layout, parent, false);
        return new SearchResultView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultView holder, int position) {
        // Get the ranking
        SearchResult searchResult = searchResultList.get(position);

        // Set the ranking data to the view
        holder.setData(searchResult);
    }

    @Override
    public int getItemCount() {
        return searchResultList.size();
    }
}
