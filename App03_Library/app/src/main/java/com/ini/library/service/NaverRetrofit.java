package com.ini.library.service;

import com.ini.library.model.NaverParent;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/*
 * Retrofit 을 사용하여 API 접속을 할 때
 * 최종 End point, header 값, method type, parameter 등을 설정하는 Interface
 */
public interface NaverRetrofit {

    /*
     * method의 return type을 void 형식이 아닌 Call Class type으로 설정
     */
    // 1. 가장 기본 type, 아무일도 할 수 없음
    public Call getBook();

    /*
     * 2. Naver OpenAPI를 사용하기 위해서는
     *      반드시 Header에 ClientID와 ClientSecret 값을 전달해주어야 한다.
     *
     * Header에 ClientID와 ClientSecret을 전달하기 위하여
     *  가. method의 매개변수에 해당 속성을 지정해준다
     *  나. @Header() annotation을 부착한다
     *  다. @Header() annotation에 Header의 이름을 지정해준다
     *      X-Naver-Client-Id=asdfghjkll;;pqoirugnm 형식으로 요청한다
     *
     * 3. method에 End point와 요청 method type을 지정한다
     *      요청 method type : @GET, @POST, @PUT, @DELETE
     *
     * 4. openAPI를 통해 데이터를 요청할 때 값, 변수 등을 보내고 싶을 때
     *      queryString을 만드는 데 여기에서는 @Query()를 사용하여 지정
     *
     * 5. return type인 Call Class에 Data를 mapping할 DTO(VO) 클래스를 Generic으로 설정해준다
    */
    @GET("book.json")
    public Call<NaverParent> getBook(
            @Header("X-Naver-Client-Id") String ClientId,
            @Header("X-Naver-Client-Secret") String ClientSecret,
            @Query("query") String query,
            @Query("start") int start,
            @Query("display") int display
    );

}
