package com.ini.movie.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.ini.movie.databinding.MovieItemViewBinding;
import com.ini.movie.model.NaverMovieDTO;

import java.util.List;

import lombok.NonNull;

public class NaverMovieAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // 리스트를 보이기 위한 데이터
    private List<NaverMovieDTO> movieList;
    public NaverMovieAdapter(List<NaverMovieDTO> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater
                = LayoutInflater.from(parent.getContext());
        MovieItemViewBinding moviewBinding
                = MovieItemViewBinding
                .inflate(layoutInflater,
                        parent,
                        false);

        return new NaverMovieViewHolder(moviewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NaverMovieViewHolder movieViewHolder
                = (NaverMovieViewHolder) holder;

        NaverMovieDTO movieDTO = movieList.get(position);
        MovieItemViewBinding binding
                = movieViewHolder.movieBinding;
        binding.movieItemTitle.setText(movieDTO.getTitle());
        binding.movieItemDirector.setText(movieDTO.getDirector());
        binding.movieItemActor.setText(movieDTO.getActor());
    }
    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class NaverMovieViewHolder extends RecyclerView.ViewHolder {

        public MovieItemViewBinding movieBinding;
        public NaverMovieViewHolder(@NonNull MovieItemViewBinding movieBinding) {
            super(movieBinding.getRoot());
            this.movieBinding = movieBinding;
        }
    }

}
