package com.example.restapi;

import com.example.restapi.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        var user = new UserRequest();
        user.setUserName("정회준");
        user.setUserAge(29);
        user.setEmail("dndn24@naver.com");
        user.setIsKorean(true);

        // DTO => JSON　직렬화 [변수에 매칭되지 않고 Get 메소드에 매칭된다]
        var json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        // JSON => DTO 역직렬화(매핑) [Setter 메소드를 참고하지만 Get 메소드를 통해서도 세팅 가능하다]
        // 혹시나 Get, Set 메소드를 둘 다 사용하지 않으면 @JsonProperty 만 사용하여 세팅할 수도 있다.
        var dto = objectMapper.readValue(json, UserRequest.class);
        System.out.println(dto);
    }

}
