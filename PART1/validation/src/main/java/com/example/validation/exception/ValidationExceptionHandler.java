package com.example.validation.exception;

import com.example.validation.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {

    // Validation 에 대한 모든 예외처리
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Api> validationException(
        MethodArgumentNotValidException exception
    ){
        log.error("", exception);

        var errorMessageList = exception.getFieldErrors().stream()
                .map(it -> {
                    var format = "%s : { %s } 은 %s";
                    var message = String.format(format, it.getField(), it.getRejectedValue(), it.getDefaultMessage());
                    return message;
                }).toList();

        var error = Api.Error
                .builder()
                .errorMessage(errorMessageList)
                .build();

        var errorResponse = Api
                .builder()
                .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .error(error)
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}
