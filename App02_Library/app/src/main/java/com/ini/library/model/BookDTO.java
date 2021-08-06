package com.ini.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String title;       // string	검색 결과 문서의 제목
    private String link;        // string	검색 결과 문서의 하이퍼텍스트 link
    private String image;       // string	썸네일 이미지의 URL
    private String author;      // string	저자 정보
    private String price;       // integer	정가 정보
    private String discount;    // integer	할인 가격 정보
    private String publisherv;  // string	출판사 정보
    private String isbn;        // integer	ISBN
    private String description; // string	검색 결과 문서의 내용을 요약한 패시지 정보
    private String pubdate;     // datetime	출간일 정보

}
