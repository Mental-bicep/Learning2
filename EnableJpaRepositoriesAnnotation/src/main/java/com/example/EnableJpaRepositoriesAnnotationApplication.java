package com.example;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.Book;
import com.repository.BookRepository;

//Notice this is in com.example.app
@SpringBootApplication

//=== THIS IS THE CORE CONCEPT ===
//Because our repository is in "com.example.repository" (a sibling package, not a sub-package),
//Spring Boot will NOT find it automatically. We MUST explicitly tell it where to look.
@EnableJpaRepositories(basePackages = "com.repository")

//Similarly, we must tell Spring where to find our @Entity classes.
@EntityScan(basePackages = "com.entity")

public class EnableJpaRepositoriesAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnableJpaRepositoriesAnnotationApplication.class, args);
	}
	
	// This runs automatically on startup to populate our H2 database.
    // Notice how we inject the repository directly into the Bean method now.
    @Bean
    public CommandLineRunner loadData(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("The Spring Handbook", "Jane Doe"));
            bookRepository.save(new Book("Learning JPA", "John Smith"));
            System.out.println("Dummy data inserted into H2 Database!");
        };
    }

}
