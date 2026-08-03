package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // @JsonBackReference tells Jackson NOT to serialize this field to prevent the infinite loop!
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;

    public Book() {}

    public Book(String title) {
        this.title = title;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
}