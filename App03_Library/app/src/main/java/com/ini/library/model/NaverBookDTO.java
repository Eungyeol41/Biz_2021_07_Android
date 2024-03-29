package com.ini.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * {
 *      rss: "rss 정보",
 *      channel : "컨테이너",
 *      ...
 *      items : [
 *          {
 *              title : "",
 *              link : "",
 *          }
 *      ]
 * }
 * 와 같이 결과가 넘어온다...?
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NaverBookDTO {

    private String title; // 검색 결과 문서의 제목
    private String link; // 검색 결과 문서의 하이퍼텍스트 link
    private String image; // 썸네일 이미지의 URL
    private String author; // 저자 정보
    private String price; // 정가 정보
    private String discount; // 할인 가격 정보
    private String publisher; // 출판사 정보
    private String isbn; // ISBN
    private String description; // 검색 결과 문서의 내용을 요약한 패시지 정보
    private String pubdate; // 출간일 정보

}