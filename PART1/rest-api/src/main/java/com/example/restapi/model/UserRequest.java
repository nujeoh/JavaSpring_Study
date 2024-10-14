package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    //Json을 받는 이름을 강제로 변경할 수 있다.
    //@JsonProperty("user_email")
    private String email;
    private Boolean isKorean;

    //ObjectMapping 시 같은 리턴값을 가진 Getter가 Json으로 넘어가는 것을 방지
    @JsonIgnore
    public String getUser(){
        return userName;
    }
}
