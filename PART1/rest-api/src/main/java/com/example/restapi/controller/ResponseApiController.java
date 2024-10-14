package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {

    // http://localhost:8080/api/v1
    // ResponseEntity로 응답 시 Error code, Header 등을 커스텀 가능하다.
    @GetMapping("")
    public ResponseEntity<UserRequest> user(){

        var user = new UserRequest();
        user.setUserName("정회준");
        user.setUserAge(29);
        user.setEmail("dndn24@naver.com");

        log.info("user : {}", user);

        var response = ResponseEntity
            .status(HttpStatus.CREATED)
            .header("x-custom","hi")
            .body(user);

        return response;
    }
}
