package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController {

    //https://localhost:8080/api/post
    // 기본으로 JSON 방식으로 데이터를 받는다.
    @PostMapping("/post")
    public BookRequest post(
        @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest;
    }

    // TODO 연습. RequsetBody로 사용자의 이름, 전화번호, 이메일을 받는 POST Method 만들기
    @PostMapping("/user")
    public UserRequest user(
        @RequestBody UserRequest userRequest
    ){
        System.out.println(userRequest);
        return userRequest;
    }
}
