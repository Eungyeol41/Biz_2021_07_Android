package com.callor.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    /*
        activity_*.xml에서 생성한 View를 Java에서 Handling하기

        View를 핸들링하기 위해서 class member 영역에 해당 View의 객체변수를 선언한다
     */
    private Button btn_login = null;
    private TextInputEditText input_email = null;
    private TextInputEditText input_pw = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml 파일에 선언된 View를 Java의 객체로 변환, 생성하기
        btn_login = findViewById(R.id.btn_login);
        input_email = findViewById(R.id.input_email);
        input_pw = findViewById(R.id.input_pw);

        btn_login.setOnClickListener((view)->{
            String email = input_email.getText().toString();
            String password = input_pw.getText().toString();

            /*
                Java code에서 정규화 문법 검사

                정규화 문자열을 생성하고
                문자열 변수의 matches() method에 정규화 문자열을 전달하여 패턴 검사
             */
            String email_pattern = "[a-zA-Z0-9._-]{3,15}+@[a-z]+\\.+[a-z]{2,3}";

            if(email.isEmpty()) {
                input_email.setError("Please Input Your Email..");
                input_email.setFocusable(true);
                return;
            } else if (!email.matches(email_pattern)) {
                input_email.setError("E_mail 형식이 잘못되었습니다.");
                return;
            }

            if (password.isEmpty()) {
                input_pw.setError("비밀번호를 입력해주세요");
                input_pw.setFocusable(true);
                return;
            }

            Intent login_intent = new Intent(MainActivity.this, LoginActivity.class);

            login_intent.putExtra("user_id", email);
            login_intent.putExtra("user_pw", password);
            startActivity(login_intent);

//            String msg = String.format("Email : %s \n P.W :  %s", email, password);
//            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        });

    }
}