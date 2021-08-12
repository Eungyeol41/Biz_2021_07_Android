package com.ini.myword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.ini.myword.databinding.ActivityWordInsertBinding;

public class WordInsertActivity extends AppCompatActivity {

    // Binding을 적용하기 위한 선언
    ActivityWordInsertBinding wordBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Binding을 적용하기 위한 생성(초기화)
        wordBinding = ActivityWordInsertBinding.inflate(getLayoutInflater());

        // Binding을 적용하여 Activity 화면 그리기
        // setContentView(R.layout.activity_word_insert);
        setContentView(wordBinding.getRoot());

        // open한 Activity에게 return하기 위한 Intent 정보 추출
        // open한 Activity에서 데이터를 보내면 그 데이터를 받는 용도로도 사용됨.
        Intent returnIntent = new Intent();

        // 저장 버튼 클릭 시
        wordBinding.btnSave.setOnClickListener(view->{

            String word = wordBinding.inputWord.getText().toString();
            String korea = wordBinding.inputKorea.getText().toString();

            // WORD, KOREA라는 변수를 각각 선언하고
            // word, korea에 담긴 값을 보내기 위하여 setting(putting) 하기
            returnIntent.putExtra("WORD", word);
            returnIntent.putExtra("KOREA", korea);

            // result 값에 setting
            // 나를 Open한 Activity <- 데이터가 준비되었으니(RESULT_OK) - 데이터를 받아라
            setResult(RESULT_OK, returnIntent);

            // 새롭게 열린 Activity에서 자신을 닫는( 끝내는 ) method
            finish();
        });
    }

}