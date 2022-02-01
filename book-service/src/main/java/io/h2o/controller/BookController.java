package io.h2o.controller;

import io.h2o.domain.Book;
import io.h2o.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/")
    public Book saveBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id){
        return bookRepository.findById(id).get();
    }

    @GetMapping("/byStudentId/{id}")
    public List<Book> getBooksByStudentId(@PathVariable int id){
        return bookRepository.findByStudentId(id);
    }
}
