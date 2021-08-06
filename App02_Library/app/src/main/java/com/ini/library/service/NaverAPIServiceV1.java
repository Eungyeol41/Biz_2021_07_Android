package com.ini.library.service;

import com.ini.library.config.Naver;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public class NaverAPIServiceV1 {

    public void getNaverBooks(String search) throws Exception {

        if(search == null) {
            search = "자바";
        }

        // 검색어 문자열을 UTF-8로 Encoding하기
        String encSearch = URLEncoder.encode(search, "UTF-8"); // Exception 처리

        // Naver Open API에 요청할 queryString 만들기
        String queryString = Naver.NAVER_BOOK_URL;
        queryString += "?query=%s";
        queryString += "display=%d";
        queryString += "&start=%d";
        queryString = String.format(queryString, encSearch, 10, 1);

        // ---  Network 코딩  ---

        // 생성한 queryString을 이용하여 Naver에 요청하기 위한 시작
        URI apiURI = new URI(queryString); // Exception 처리




    }
}
