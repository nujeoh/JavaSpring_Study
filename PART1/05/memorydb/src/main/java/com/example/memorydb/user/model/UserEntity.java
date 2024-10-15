package com.example.memorydb.user.model;

import com.example.memorydb.entity.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity extends Entity {

    private String name;
    private int score;
}
