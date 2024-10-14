package com.example.restapi.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Camel case > Snake case 로 자동 매핑 시켜줌(JSON 데이터를 요청 받을 때)
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
    private String userName;
    private Integer userAge;
    private String email;
    private Boolean isKorean;
}
