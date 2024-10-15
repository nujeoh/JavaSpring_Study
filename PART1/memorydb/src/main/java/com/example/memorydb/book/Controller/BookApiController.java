package com.example.memorydb.book.Controller;

import com.example.memorydb.book.model.BookEntity;
import com.example.memorydb.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

    private final BookService bookService;

    // Create
    @PostMapping("")
    public BookEntity create(
        @RequestBody BookEntity bookEntity
    ){
        return bookService.create(bookEntity);
    }

    // Read
    @GetMapping("/all")
    public List<BookEntity> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<BookEntity> findById(
        @PathVariable Long id)
    {
        return bookService.findById(id);
    }

    // TODO category 를 특정하여 min<=amount<=max 조회
    @GetMapping("/filter")
    public <min> List<BookEntity> filterCategory(
        @RequestParam String category,
        @RequestParam(required = false, defaultValue = "0") int min,
        @RequestParam(required = false, defaultValue = "0") int max
    ){
        if(min == 0 || max == 0){
            return bookService.filterCategory(category);
        }else{
            return bookService.filterCategory(category).stream()
                    .filter(it -> it.getAmount() >= min)
                    .filter(it -> it.getAmount() <= max)
                    .collect(Collectors.toList());
        }

    }

    // Delete
    @DeleteMapping("/id/{id}")
    public void delete(
        @PathVariable Long id
    ){
        bookService.deleteById(id);
    }
}
