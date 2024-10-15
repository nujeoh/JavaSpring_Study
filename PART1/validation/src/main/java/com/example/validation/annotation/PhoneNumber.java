package com.example.validation.annotation;

import com.example.validation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PhoneNumberValidator.class})
@Target({ElementType.FIELD}) // 변수에만 적용
@Retention(RetentionPolicy.RUNTIME) // 실행 중일 때만 동작
public @interface PhoneNumber {
    String message() default "핸드폰 번호 양식에 맞지 않습니다. ex) 000-0000-0000";
    String regexp() default "^\\d{2,3}-\\d{3,4}-\\d{4}$";

    java.lang.Class<?>[] groups() default {};

    java.lang.Class<? extends jakarta.validation.Payload>[] payload() default {};
}
