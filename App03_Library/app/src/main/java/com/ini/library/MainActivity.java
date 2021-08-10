package com.ini.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ini.library.service.NaverBookService;
import com.ini.library.service.impl.NaverBookServiceImplV1;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.book_list_view);
//        recyclerView.setOnClickListener(view-> {

            NaverBookService naverBookService = new NaverBookServiceImplV1();
            naverBookService.getBooks("자바");

//        });

    }
}