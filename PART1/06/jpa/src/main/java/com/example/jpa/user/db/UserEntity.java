package com.example.jpa.user.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
public class UserEntity { // 맵핑하기 위한 ORM

    @Id //Primary key 에 달아줘야 하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Identity 방식으로 생성하겠다(DB 마다 다를 수 있다)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
