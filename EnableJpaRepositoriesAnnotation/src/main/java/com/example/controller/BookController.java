package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Book;
import com.repository.BookRepository;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    // Constructor Injection
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // The endpoint is now neatly separated in its own Controller class
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
