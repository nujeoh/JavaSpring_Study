package com.example.memorydb.book.repository;

import com.example.memorydb.book.model.BookEntity;
import com.example.memorydb.db.SimpleDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service // bean 생성을 위해 넣어주자
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {

    public List<BookEntity> BookFilerCategory(String category) {
        return findAll().stream()
                .filter(it -> {
                    return it.getCategory().equals(category);
                }).collect(Collectors.toList());
    }
}
