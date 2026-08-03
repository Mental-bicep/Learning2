package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    private final AuthorRepository authorRepository;

    public LibraryController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        // Because of our annotations, this will return the Authors with their Books,
        // but the Books won't infinitely loop back to the Authors!
        return authorRepository.findAll();
    }
}