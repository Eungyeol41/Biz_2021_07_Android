package com.ini.mymovie.service.impl;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ini.mymovie.adapter.NaverMovieAdapter;
import com.ini.mymovie.config.NaverAPI;
import com.ini.mymovie.model.NaverMovieDTO;
import com.ini.mymovie.model.NaverParent;
import com.ini.mymovie.service.NaverMovieService;
import com.ini.mymovie.service.NaverRetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverMovieServiceImplV1 implements NaverMovieService {

    protected RecyclerView recyclerView;
    public NaverMovieServiceImplV1(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public void getMovies(String search) {

        Call<NaverParent> movieCall = NaverRetrofitClient.getApiClient()
                .getMovie(NaverAPI.CLIENT_ID, NaverAPI.CLIENT_SECRET, search, 1, 15);

        movieCall.enqueue(new Callback<NaverParent>() {
            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {

                int resCode = response.code();
                if (resCode < 300) {
                    Log.d("네이버 영화는 어떤 게 있을까?", response.body().toString());

                    List<NaverMovieDTO> movieList = response.body().items;
                    NaverMovieAdapter movieAdapter = new NaverMovieAdapter(movieList);

                    recyclerView.setAdapter(movieAdapter);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
                    recyclerView.setLayoutManager(layoutManager);

                } else {
                    Log.d("Error 발생!!!", response.toString());
                }

            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }
        });

    }

//    public void getGenre(String )





}
