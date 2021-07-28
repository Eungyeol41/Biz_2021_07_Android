package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;

import com.callor.hello.model.UserDTO;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_join = null;
    private TextInputEditText input_id = null;
    private TextInputEditText input_pw = null;
    private TextInputEditText input_name = null;
    private TextInputEditText input_tel = null;
    private TextInputEditText input_addr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_join = findViewById(R.id.btn_join);
        input_id = findViewById(R.id.input_1);
        input_pw = findViewById(R.id.input_2);
        input_name = findViewById(R.id.input_3);
        input_tel = findViewById(R.id.input_4);
        input_addr = findViewById(R.id.input_5);

        btn_join.setOnClickListener((view)-> {
            String id = input_id.getText().toString();
            String password = input_pw.getText().toString();
            String name = input_name.getText().toString();
            String tel = input_tel.getText().toString();
            String addr = input_addr.getText().toString();

            UserDTO user = new UserDTO();
            user.user_id = id;
            user.password = password;
            user.tel = tel;
            user.addr = addr;

            // 부르는쪽 this, 불리는쪽 class
            Intent intent = new Intent(MainActivity.this, JoinActivity.class);

            // Extra에 객체도 담을 수 있다
            intent.putExtra("USER", (Parcelable)user); // 시리얼라이징

            startActivity(intent);

        });


    }
}