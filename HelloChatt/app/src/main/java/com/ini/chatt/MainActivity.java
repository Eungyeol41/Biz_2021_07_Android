package com.ini.chatt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ini.chatt.adapter.ChattAdapter;
import com.ini.chatt.model.Chatt;
import com.ini.chatt.service.FirebaseServiceImplV1;

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

    // firebase와 연결하는 Connection을 위한 객체 선언하기
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * setContentView(R.layout.activity_main);
         *  *_layout.xml 파일을 읽어서 화면을 만드는 method
         *  setContentView는 한 개의 파일을 읽어서 한 개의 전체 화면을 만드는 것
         */
        setContentView(R.layout.activity_main);

        chatt_list_view = findViewById(R.id.chatt_list_view);

        // 0. 보여줄 데이터 객체 생성
        chattList = new ArrayList<Chatt>();

        // 1. Adapter 객체 생성
        // Adapter 객체를 생성할 때 보여줄 데이터 객체를 생성자 매개변수로 주입해주어야 한다.
        chattAdapter = new ChattAdapter(chattList);

        // 2. RecyclerView.Adapter와 RecyclerView 연결
        chatt_list_view.setAdapter(chattAdapter);

        // RecyclerView에 데이터들을 표현하는 데 사용할 Layout 매니저를 설정하기
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        chatt_list_view.setLayoutManager(layoutManager);

        FirebaseDatabase dbConn = FirebaseDatabase.getInstance();
        // 사용할 table 선언 (RealDatabase에서는 table을 path라는 명칭을 사용함)
        dbRef = dbConn.getReference("chatting");

        // firebase로부터 데이터 변화 이벤트가 전달되면 이벤트를 수신하여 할 일을 지정하기
        // 이벤트를 수신하여 할 일을 지정하기 위한 핸들러 선언
        ChildEventListener childEventListener = new FirebaseServiceImplV1(chattAdapter);

        // 이벤트 핸들러 연결
        dbRef.addChildEventListener(childEventListener);

        txt_msg = findViewById(R.id.txt_msg);
        btn_send = findViewById(R.id.btn_send);



        // 테스트를 위한 가상의 데이터
        /*
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
         */

        /**
         * EditBox에 메시지를 입력하고 Send 버튼을 클릭했을 때 할 일을 지정하기
         *
         * EditBox에 메시지를 입력하고 Send를 하면 Firebase의 Realtime DataBase에 데이터를 insert할 것것         */
        btn_send.setOnClickListener(view->{
            String msg = txt_msg.getText().toString();

            if(msg != null && !msg.isEmpty()) {

                String toastMsg = String.format("메시지 : %s", msg);
                Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT).show();

                Chatt chattVO = new Chatt();
                chattVO.setMsg(msg);
                chattVO.setName("Hong");

                Log.d("OnClick", chattVO.toString());

                // chattList.add(chattVO);
                // firebase의 Realtime DB의 table에 데이터를 insert(push)하라
                dbRef.push().setValue(chattVO);
                txt_msg.setText("");
            }
        });

    }
}