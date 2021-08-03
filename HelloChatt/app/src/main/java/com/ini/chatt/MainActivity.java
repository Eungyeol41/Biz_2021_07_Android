package com.ini.chatt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;

import com.ini.chatt.adapter.ChattAdapter;
import com.ini.chatt.model.Chatt;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // chatt 메시지를 전달하는 View들
    private EditText txt_msg;
    private AppCompatButton btn_send;

    // chatt 메시지를 표현할 View들
    private RecyclerView chatt_list_view;
    private ChattAdapter chattAdapter;
    private List<Chatt> chattList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * setContentView(R.layout.activity_main);
         *  *_layout.xml 파일을 읽어서 화면을 만드는 method
         *  setContentView는 한 개의 파일을 읽어서 한 개의 전체 화면을 만드는 것
         */
        setContentView(R.layout.activity_main);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);

        chatt_list_view = findViewById(R.id.chatt_list_view);
        // 0. 보여줄 데이터 객체 생성
        chattList = new ArrayList<Chatt>();
        Chatt chatt = new Chatt();
        chatt.setName("Hong");
        chatt.setMsg("Hello");
        chattList.add(chatt);

        chatt = new Chatt();
        chatt.setName("Sung");
        chatt.setMsg("졸렼!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        chattList.add(chatt);

        chatt = new Chatt();
        chatt.setName("Nanak");
        chatt.setMsg("이거 알듯말듯하는거면 모르는 거 맞죠?");
        chattList.add(chatt);

        // 1. Adapter 객체 생성
        // Adapter 객체를 생성할 때 보여줄 데이터 객체를 생성자 매개변수로 주입해주어야 한다.
        chattAdapter = new ChattAdapter(chattList);

        // 2. RecyclerView.Adapter와 RecyclerView 연결
        chatt_list_view.setAdapter(chattAdapter);

        // RecyclerView에 데이터들을 표현하는 데 사용할 Layout 매니저를 설정하기
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        chatt_list_view.setLayoutManager(layoutManager);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

    }
}