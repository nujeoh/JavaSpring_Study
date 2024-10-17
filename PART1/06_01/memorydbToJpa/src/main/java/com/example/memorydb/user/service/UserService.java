package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import org.apache.catalina.User;
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
        return userRepository.findAllByScoreGreaterThanEqual(score);
    }

//    public List<UserEntity> filterScore(int min, int max){
//        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(min, max);
//    }

    public List<UserEntity> filterScore(int min, int max){
        return userRepository.score(min, max);
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    // Delete
    public void delete(UserEntity userEntity){
        userRepository.delete(userEntity);
    }
}
