package com.ini.movie.service;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ini.movie.adapter.NaverMovieAdapter;
import com.ini.movie.config.NaverAPI;
import com.ini.movie.model.MovieDTO;
import com.ini.movie.model.NaverParent;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverMovieServiceImplV1 implements NaverAPIService{

    protected RecyclerView recyclerView;

    public NaverMovieServiceImplV1(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public void getNaverData(String search) {

        Call<NaverParent> naverCall = RetrofitClient.getApiClient().getMovie(NaverAPI.NAVER_CLIENT_ID, NaverAPI.NAVER_CLIENT_SECRET, search, 1, 15);
        naverCall.enqueue(new Callback<NaverParent>() {
            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {
                Log.d("Response", response.toString());

                int resCode = response.code();
                if (resCode < 300) {
                    NaverParent movieData = response.body();
                    Log.d("네이버에서 받은 데이터", movieData.toString());

                    List<MovieDTO> movieList = movieData.items;

                    NaverMovieAdapter adapter = new NaverMovieAdapter(movieList);
                    recyclerView.setAdapter(adapter);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
                    recyclerView.setLayoutManager(layoutManager);
                }
            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }
        });


    }
}
