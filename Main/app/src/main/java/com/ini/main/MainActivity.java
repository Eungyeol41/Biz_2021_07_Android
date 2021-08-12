package com.ini.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
        final Animation animation_du4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_1);
        final Animation animation_du2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_2);
        final Animation animation_x5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_3);
        final Animation animation_du3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.test);

        View view01 = findViewById(R.id.plus1);
        view01.startAnimation(animation);

        View view02 = findViewById(R.id.plus2);
        view02.startAnimation(animation_du4);

        View view03 = findViewById(R.id.plus3);
        view03.startAnimation(animation_du2);

        View view04 = findViewById(R.id.plus4);
        view04.startAnimation(animation_du3);

        View view05 = findViewById(R.id.plus5);
        view05.startAnimation(animation_x5);


    }
}