package com.example.jpa.user.controller;

import com.example.jpa.user.db.UserEntity;
import com.example.jpa.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    //user table 의 모든 데이터
    @GetMapping("find-all")
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    //RequestPara 으로 이름 값만 받아서 user table 에 insert
    @GetMapping("/name")
    public void autoSave(
        @RequestParam String name
    ){
        var user = UserEntity.builder()
                .name(name)
                .build();
        userRepository.save(user);
    }
}
