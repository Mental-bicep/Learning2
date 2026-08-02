package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Book;

// Notice this is in com.example.repository
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}