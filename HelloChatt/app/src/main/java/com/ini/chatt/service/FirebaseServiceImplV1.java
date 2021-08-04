package com.ini.chatt.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.ini.chatt.adapter.ChattAdapter;
import com.ini.chatt.model.Chatt;

public class FirebaseServiceImplV1 implements ChildEventListener {

    private ChattAdapter adapter;

    public FirebaseServiceImplV1(ChattAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

        // 데이터를 가져오는 데 그 데이터는 Chatt.class와 같은 구조로 만들어져있다.
        Chatt chattVO = snapshot.getValue(Chatt.class);
        adapter.addChattList(chattVO);

        // Exception이 발생할 것이다.. Why?
        // adapter를 선언했지만 생성을 하지 않았다.
        // adapter 생성은 생성자를 만들어서 주입을 시켜줘야 한다.

    }

    @Override
    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

    }

    @Override
    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
}
