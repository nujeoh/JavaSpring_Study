package com.example.cookie.controller;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public UserDto me(
            HttpServletRequest request,
            @CookieValue(name = "authorization-cookie", required = false)
            String authorizationCookie
    ){
        log.info("authorizationCookie : {}", authorizationCookie);

        var optionalUser = userRepository.findById(authorizationCookie);

        return optionalUser.get();
/*
        var cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie: cookies){
                log.info("key : {}, value :{}", cookie.getName(), cookie.getValue());
            }

        }
*/
    }
}
