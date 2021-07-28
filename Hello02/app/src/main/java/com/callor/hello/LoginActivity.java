package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView txt_msg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_msg = findViewById(R.id.text_login_msg);

        // 나를 호출한 Activity를 추출하기
        Intent intent = getIntent();

        String user_id = intent.getExtras().getString("user_id");
        String user_pw = intent.getExtras().getString("user_pw");

        String msg = String.format("Email : %s\nP.W : %s", user_id, user_pw);
        txt_msg.setText(msg);
    }
}