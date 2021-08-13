package com.ini.mymovie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ini.mymovie.databinding.ActivityMainBinding;
import com.ini.mymovie.service.NaverMovieService;
import com.ini.mymovie.service.impl.NaverMovieServiceImplV1;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding main_binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(main_binding.getRoot());

        NaverMovieService movieService = new NaverMovieServiceImplV1(main_binding.movieListView);
        movieService.getMovies("모가디슈");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_toolbar_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("영화 검색");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("검색 버튼 클릭", query);

                NaverMovieService naverMovieService = new NaverMovieServiceImplV1(main_binding.movieListView);
                naverMovieService.getMovies(query.trim());

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}