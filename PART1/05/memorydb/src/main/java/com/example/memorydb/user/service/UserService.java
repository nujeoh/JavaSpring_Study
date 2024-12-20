package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create
    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    // Read
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public List<UserEntity> filterScore(int score){
        return userRepository.findAllScoreGreaterThen(score);
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    // Delete
    public void delete(Long id){
        userRepository.delete(id);
    }
}
