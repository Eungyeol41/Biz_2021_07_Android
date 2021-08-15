package com.ini.mymovie.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ini.mymovie.databinding.MovieItemViewBinding;

import com.ini.mymovie.model.NaverMovieDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NaverMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NaverMovieDTO> movieList;

    public NaverMovieAdapter(List<NaverMovieDTO> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        MovieItemViewBinding movieBinding = MovieItemViewBinding.inflate(layoutInflater, parent, false);

        return new MovieItemHolder(movieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieItemHolder movieHolder = (MovieItemHolder) holder;
        MovieItemViewBinding movieBinding = movieHolder.viewBinding;

        NaverMovieDTO movieDTO = movieList.get(position);

        Spanned movie_title = Html.fromHtml(movieDTO.getTitle(), Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemTitle.setText(movie_title);


        Spanned movie_subtitle = Html.fromHtml(movieDTO.getSubtitle(), Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemSubtitle.setText(movie_subtitle);

        Spanned movie_pubdate = Html.fromHtml(movieDTO.getPubDate(), Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemPubDate.setText(movie_pubdate);

        Spanned movie_director = Html.fromHtml(movieDTO.getDirector(), Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemDirector.setText(movie_director);

        Spanned movie_actor = Html.fromHtml(movieDTO.getActor(), Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemActor.setText(movie_actor);

        Spanned movie_userRating = Html.fromHtml(movieDTO.getUserRating(), Html.FROM_HTML_MODE_LEGACY);
        movieBinding.movieItemUserRating.setText(movie_userRating);

        if (!movieDTO.getImage().isEmpty()) {
            Picasso.get().load(movieDTO.getImage()).into(movieBinding.movieItemImage);
        }

    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class MovieItemHolder extends RecyclerView.ViewHolder {

        public MovieItemViewBinding viewBinding;

        public MovieItemHolder(@NonNull MovieItemViewBinding viewBinding) {
            super(viewBinding.getRoot());
            this.viewBinding = viewBinding;
        }
    }
}
