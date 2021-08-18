package com.ini.movie.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ini.movie.databinding.MovieItemViewBinding;
import com.ini.movie.model.MovieDTO;

import java.util.List;

public class NaverMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieDTO> movieList;

    public NaverMovieAdapter(List<MovieDTO> movieList) {
        this.movieList = movieList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        MovieItemViewBinding movieBinding = MovieItemViewBinding.inflate(layoutInflater, parent, false);

        return new MovieViewHolder(movieBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieViewHolder viewHolder = (MovieViewHolder) holder;
        MovieDTO movieDTO = movieList.get(position);
        MovieItemViewBinding mBinding = viewHolder.movieBinding;

        // Html tag 제거하기 위한 코드
        Spanned sTitle = Html.fromHtml(movieDTO.getTitle(), Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemTitle.setText(sTitle);

        movieDTO.setDirector(movieDTO.getDirector().replace("|"," "));
        String strDirector = String.format("<b>감독 : </b> %s", movieDTO.getDirector());
        Spanned sDirector = Html.fromHtml(strDirector, Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemDirector.setText(sDirector);

        /*

        String[] splitActor = movieDTO.getActor().split("|");
        // 배우1|배우2|배우3|
        int lastSize = splitActor.length-1;
        if (splitActor[lastSize]=="|"){
            splitActor[lastSize] = " ";
            movieDTO.setActor(splitActor.toString());
        }
//        movieDTO.setActor(splitActor[splitActor.length-1].replace("|", " "));

         */
        String strActor = String.format("<b>출연 배우 : </b> %s", movieDTO.getActor());
        Spanned sActor = Html.fromHtml(strActor, Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemActor.setText(sActor);

        Spanned sURating = Html.fromHtml(movieDTO.getUserRating(), Html.FROM_HTML_MODE_LEGACY);
        mBinding.movieItemRating.setText(sURating);

        /*
        glide를 사용하여 이미지 링크를 참조하여 이미지 표현하기
         */
        if (!movieDTO.getImage().isEmpty()) {
            Glide.with(mBinding.movieItemImage.getContext())
                    .load(movieDTO.getImage())
                    .into(mBinding.movieItemImage);
        }

    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        public MovieItemViewBinding movieBinding;

        public MovieViewHolder(@NonNull MovieItemViewBinding movieBinding) {
            super(movieBinding.getRoot());
            this.movieBinding = movieBinding;
        }
    }

}
