package com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data //lombok을 사용하여 기존 생성자, getter-setter method 자동 생성
@AllArgsConstructor // 전체 파라미터가 들어간 생성자 생성(기존 생성자 제외)
@NoArgsConstructor // 기존 생성자 생성
public class BookQueryParam {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;

}
