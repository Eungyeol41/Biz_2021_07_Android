package com.ini.myword;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.ini.myword.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    // SFR(startActivityForResult) 기능을 새롭게 구현하기 위하여 객체 선언
    private ActivityResultLauncher<Intent> startActivityResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        /*
         * SFR을 구현하기 위하여 startActivityResult 객체를 초기화 하기
         * 객체를 초기화할 때 2개의 새로운 객체를 주입하면서 객체를 초기화 해야한다
         */
        ActivityResultContracts.StartActivityForResult activityForResultContract = new ActivityResultContracts.StartActivityForResult();
        ActivityResultCallback<ActivityResult> activityResultCallback = new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                // SFR을 실행하여 새로운 Activity에서 값을 되돌려주었을 때 값을 수신하는 method
                Log.d("Return", "Activity가 끝나고 다시 되돌아 옴");

                // WordInsertActivity에서 보낸 변수 이름
                String word = result.getData().getStringExtra("WORD");
                String korea = result.getData().getStringExtra("KOREA");

                Log.d("WORD", word);
                Log.d("KOREA", korea);

            }
        };

        // 위에서 생성한 ResultContract와 ResultCallback을 (생성자의) 매개변수로 전달하면서 객체를 초기화하기
        startActivityResult = registerForActivityResult(activityForResultContract, activityResultCallback);

        binding.fab.setOnClickListener(view->{
            Intent wordIntent = new Intent(MainActivity.this, WordInsertActivity.class);

            // 단순히 새로운 Activity를 여는 방법
            // startActivity(wordIntent);

            /*
             * 현재 Activity(Main)에서 새로운 Activity(WordInsert)를 열고
             *  새로 열린 Activity에서 단어를 입력하고 저장버튼을 클릭하면 입력된 단어로 다시 Main으로 되돌려주기 위한 Activity Open
             */
            startActivityResult.launch(wordIntent);

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

}