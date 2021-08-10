package com.ini.library.service.impl;

import android.util.Log;

import com.ini.library.config.NaverAPI;
import com.ini.library.model.NaverBookDTO;
import com.ini.library.model.NaverParent;
import com.ini.library.service.NaverBookService;
import com.ini.library.service.RetrofitAPIClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NaverBookServiceImplV1 implements NaverBookService {

    @Override
    public NaverBookDTO getBooks(String search) {

        // 1. Retrofit을 사용하여 Naver에서 데이터 가져오기
        /*
         * RetrofitAPIClient의 getApiClient() method는 Retrofit Interface에 선언된 method를 동반한다
         *    동반된 method( getBook() )를 호출하면서 필요한 매개변수를 전달하면
         *      Retrofit은 Naver server에 요청을 하고 그 요청을 비동기 방식으로 기다리게 된다
         *
         * 2. 비동기 방식
         *      호출하는 곳과 응답을 처리하는 곳이 다르다
         *      호출하는 곳에서는 호출만 하고 즉시, 자신의 다른 일을 수행하는 것을 계속한다
         *
         *      응답이 오면 그 응답을 처리할 CallBack을 적절히 처리해주어야 한다
         *
         *      'event Handling 처리' 라고도 한다
         *
         * 3. 동기 방식
         *      어떤 요청을 호출하고, 결과를 마냥 기다리다가 결과가 오면 변수에 담고 이후에 처리하는 코드가 수행된다
         */
        // event를 설정할 대상이 있어야 하기 때문에 아래와 같이 설정함.
         Call<NaverParent> retrofitReturn = RetrofitAPIClient.getApiClient().getBook(NaverAPI.CLIENT_ID, NaverAPI.CLIENT_SECRET, search, 1, 10);

        /*
         * Retrofit의 요청을 받은 Naver가 데이터를 보내면 Retrofit이 응답을 받아서 처리할 event(Call Back)
         *
         * Call Back Event Handling 코드
         * CallBack Interface를 익명 Class로 선언하는 코드
         *      Skeletone Code ( 익명 클래스 코드... )
         */
        retrofitReturn.enqueue(new Callback<NaverParent>() {
            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {

                // 응답을 받았을 때 HttpCode가 무엇인지를 확인하기 위하여 작성한 코드
                // Http response code를 가져오기
                int resCode = response.code();
                // 300 미만은 정상적인 코드임
                if (resCode < 300) {
                    Log.d("Naver 응답 데이터", response.body().toString());
                } else {
                    Log.d("Error!!!!", response.toString());
                }

            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }
        });
        return null;
    }

}
