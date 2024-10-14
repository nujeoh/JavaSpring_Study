package com.example.exception.exception;

import com.example.exception.controller.RestApiBController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
// 좀 더 글로벌한 예외처리(모든 Conroller의 Exception)
//@RestControllerAdvice(basePackages = "com.example.exception.controller")//basePackages 를 설정하면 해당 Package 안의 컨트롤러로 특정하여 예외처리
@RestControllerAdvice(basePackageClasses = {RestApiBController.class}) // 특정한 Controller 의 예외처리만 가능
@Order(1) // 먼저 실행될 Exception
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
        IndexOutOfBoundsException e
    ){
        log.error("IndexOutOfBoundsException", e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> noSuchElement(
        NoSuchElementException e
    ){
        log.error("NoSuchElementException", e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
