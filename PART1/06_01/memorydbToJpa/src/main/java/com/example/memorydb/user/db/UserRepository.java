package com.example.memorydb.user.db;

import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    //Spring Data JPA 에서 지원하는 Query Method 생성하는 법
    // select * from user where score > [??]
    List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    // select * from user where score >= [??] AND score <= [??]
    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    // Query Method 말고 Annotation 을 통해 Native 하게 쿼리문 작성도 가능하다.
    @Query(
        //"select u from user u where u.score >= ?1 AND u.score <= ?2" // << jpql 문법을 통한 쿼리문 작성, 기본 바인딩 방법
        value = "select * from user as u where u.score >= :min AND u.score <= :max", // << Native 쿼리문 작성
        nativeQuery = true
    )
    List<UserEntity> score(
        @Param(value = "min") int min, // @Param Annotation 을 통한 바인딩 방법
        @Param(value = "max") int max
    );
}
