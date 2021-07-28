package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JoinActivity extends AppCompatActivity {

    private TextView join_msg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        join_msg = findViewById(R.id.txt_msg_join);

        Intent intent = getIntent();

        String user_id = intent.getExtras().getString("user_id");
        String user_pw = intent.getExtras().getString("user_pw");
        String user_name = intent.getExtras().getString("user_name");
        String user_tel = intent.getExtras().getString("user_tel");
        String user_addr = intent.getExtras().getString("user_addr");

        String msg = String.format("Email : %s\nP.W : %s\n이름 : %s\n전화번호 : %s\n주소 : %s", user_id, user_pw, user_name, user_tel, user_addr);
        join_msg.setText(msg);

    }
}