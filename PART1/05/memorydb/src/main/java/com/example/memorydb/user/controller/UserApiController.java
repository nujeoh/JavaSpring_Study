package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    // Create
    @PutMapping("")
    public UserEntity create(
        @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity);
    }

    // Read
    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<UserEntity> findById(
        @PathVariable Long id
    ){
        return userService.findById(id);
    }

    //Delete
    @DeleteMapping("/id/{id}")
    public void deleteById(
        @PathVariable Long id
    ){
        userService.delete(id);
    }

    // TODO 사용자 10명 등록 후 Score가 70점 이상의 사용자의 정보를 찾아주는 method 작성하기
    @GetMapping("/score")
    public List<UserEntity> filterScore(
        @RequestParam int score
    ){
        return userService.filterScore(score);
    }
}
