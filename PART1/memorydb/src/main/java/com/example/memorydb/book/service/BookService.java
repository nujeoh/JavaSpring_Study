package com.example.memorydb.book.service;

import com.example.memorydb.book.model.BookEntity;
import com.example.memorydb.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

//    private BookService(BookRepository bookRepository) { // 이렇게 직접 생성자를 넣어주거나 final + @RequiredArgsConstructor
//        this.bookRepository = bookRepository;            // 또는 final 을 빼고 @Autowired 를 쓰는 3가지 방법이 있다.
//    }

    // Create, Update
    public BookEntity create(BookEntity book){
        return bookRepository.save(book);
    }

    // Read
    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }

    public Optional<BookEntity> findById(Long id){
        return bookRepository.findById(id);
    }

    public List<BookEntity> filterCategory(String category){
        return bookRepository.BookFilerCategory(category);
    }

    // Delete
    public void deleteById(Long id){
        bookRepository.delete(id);
    }
}
