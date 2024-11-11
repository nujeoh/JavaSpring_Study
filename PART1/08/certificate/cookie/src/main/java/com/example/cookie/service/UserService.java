package com.example.cookie.service;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpServletResponse response
    ){
        var id = loginRequest.getId();
        var password = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);

        if (optionalUser.isPresent()) {
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(password)) {
                // cookie 해당 정보를 저장
                var cookie = new Cookie("authorization-cookie", userDto.getId());
                cookie.setDomain("localhost");  // naver.com, daum.net 등 사용할 도메인
                cookie.setPath("/");
                cookie.setHttpOnly(true); // javascript cookie value 탈취 방지
                //cookie.setSecure(true); // << https 에서만 사용되도록 설정
                cookie.setMaxAge(-1); // == session

                response.addCookie(cookie);
            }

        }else{
            throw new RuntimeException("User not found");
        }
    }
}
