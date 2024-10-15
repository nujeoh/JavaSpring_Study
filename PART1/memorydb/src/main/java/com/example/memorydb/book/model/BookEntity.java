package com.example.memorydb.book.model;

import com.example.memorydb.entity.Entity;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookEntity extends Entity {

    private String name;
    private String category;
    private int amount;
}
