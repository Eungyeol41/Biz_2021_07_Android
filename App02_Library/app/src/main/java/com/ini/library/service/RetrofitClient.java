package com.ini.library.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ini.library.config.Naver;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // 1. OpenAPI와 연결할 Connection 객체를 생성하고
    private static Retrofit getInstance() {

        // Retrofit으로 OpenAPI로 데이터를 가져오면 자동 Parsing을 도와줄 객체
        Gson gson = new GsonBuilder().setLenient().create();

        // Naver.NAVER_BOOK_URL과 연결하는 HTTP Connection을 하나 설정하고 객체를 만들어라
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Naver.NAVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }

    // 2. 미리 만들어 둔 NaverRetrofitService interface와 연동하여 데이터를 Parsing하는 코드를 생성하여 return
    public static NaverRetrofitService getClient() {
        return getInstance().create(NaverRetrofitService.class);
    }

}
