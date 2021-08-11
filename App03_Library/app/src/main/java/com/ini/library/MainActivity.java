package com.ini.library;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;

import com.ini.library.service.NaverBookService;
import com.ini.library.service.impl.NaverBookServiceImplV1;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    /*
     * Life Cycle
     * 폰에서 아이콘을 터치하여 App 실행
     * App 사용하고
     * App 종료하고
     *
     * App을 실행했을 때
     * Android가 폰에서 어플을 읽어서 메모리에 load하고 화면 구성 요소를 읽어서 화면을 그리고
     *      onCreate**() method 내에 관련된 코드 실행
     * 각 기능을 사용하기 위한 여러가지 Event Handler를 등록한다
     *
     * @param savedInstanceState
     */
    @Override
    // life cycle에서 start Up Method, start point method
    // App이 실행될 때 가장 먼저 작동하는 method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar main_toolbar = findViewById(R.id.main_app_toolbar);
        setSupportActionBar(main_toolbar);

        recyclerView = findViewById(R.id.book_list_view);

        NaverBookService naverBookService = new NaverBookServiceImplV1(recyclerView);
        naverBookService.getBooks("자바");

    }

    /*
     * res/menu/menu.xml 파일을 읽어서 화면의 ActionBar에 메뉴 등을 표현할 때 사용하는 method
     *
     * 이 method는 Android가 App을 화면에 띄울 때 자동으로 호출하여 사용하는 method
     *
     * activity.xml 파일에 toolbar 관련된 항목이 있으면 Android는 MainActivity에 onCreateOptionsMenu() 가 있는 지 확인하고
     *  있으면 해당 method를 호출하여 실행한다
     *
     * ActionBar에 보여줄 여러가지 항목이나, 기능 등을 설정(선언언을 여기에서 수행하면 된다.
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // 매개변수로 받은 menu는 toolbar에 기본으로 포함된 아무것도 없는 상태의 menu 객체

        // 현재 toolbar에 기본으로 포함된 blank menu 객체에
        //  main_toolbar_menu.xml 파일에 작성되어 있는 item 요소를 추가하여 toolbar에 메뉴가 나타나도록 하여라
        getMenuInflater().inflate(R.menu.main_toolbar_menu, menu);

        /*
         * ActionBar(AppBar)에 설정된 search 기능 구현하기
         */
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();

        /*
         * Integer.MAX_VALUE
         * Java에서 표현할 수 있는 정수의 최대값
         */
        // SearchBar width를 최대값으로 설정하여 화면에 가득차도록
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("도서명 검색");

        /*
         * 검색창에 값이 입력되고, 키보드의 돋보기(검색)을 클릭 시 반응할 Event 설정하기
         */
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            // 검색창에 문자열을 입력하고 키보드의 검색(돋보기) 버튼을 클릭했을 때의 반응응
           @Override
            public boolean onQueryTextSubmit(String query) {
               Log.d("검색 버튼 클릭", query);

               NaverBookService naverBookService = new NaverBookServiceImplV1(recyclerView);
               naverBookService.getBooks(query.trim());

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("현재 입력하는 문자열 : ", newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}