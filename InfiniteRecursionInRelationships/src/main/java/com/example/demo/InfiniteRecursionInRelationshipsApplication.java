package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InfiniteRecursionInRelationshipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfiniteRecursionInRelationshipsApplication.class, args);
	}
	
	// Load some dummy data on application startup
    @Bean
    public CommandLineRunner loadData(AuthorRepository repository) {
        return args -> {
            Author author = new Author("George Orwell");
            
            // Because of our helper method, this sets up both sides of the relationship
            author.addBook(new Book("1984"));
            author.addBook(new Book("Animal Farm"));

            // CascadeType.ALL ensures the books are saved when we save the author
            repository.save(author);
            
            System.out.println("Data loaded successfully! Go to http://localhost:8080/api/authors");
        };
    }

}
