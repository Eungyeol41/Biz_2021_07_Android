package com.ini.movie;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.ini.movie.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;



import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // menu.xml에 item으로 설정된 항목 중에서 SearchView 클래스가 지정된 item을 가져와서
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("영화 검색");

        // 검색창에 검색어를 입력하고 키보드의 검색(Search Icon)을 클릭했을 때 반응하는 event 핸들러
        // 검색창에 문자열을 입력할 때, 검색을 클릭했을 때 반응하는 Event
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("입력한 검색어", query);

                // if (!query.isEmpty())
                if (query.isEmpty() == false) {

                    /*
                    actionFirstFragmentToSecondFragment() method에 값 주입하여 SecondFragment로 값 전달하기
                    nav_graph.xml에 설정된 argument 변수에 값을 세팅하는 것으로 'defaultValue' 값을 없애고 매개변수로 값을 주입하여 전달한다
                     */
                    NavDirections action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(query);

                    NavController controller = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_content_main);

                    // 열려있는 Search 창을 닫는 method
                    menu.findItem(R.id.app_bar_search).collapseActionView();

                    // 만약 FirstFragment 화면이 아닌 경우 SecondFragment 화면이 열려 있는 상태이면 위로 가기를 한 번 실행하고 navigation을 이동하라
                    controller.navigateUp();
                    controller.navigate(action);

                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


}