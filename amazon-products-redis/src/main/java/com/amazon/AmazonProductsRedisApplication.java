package com.amazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class AmazonProductsRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonProductsRedisApplication.class, args);
	}

}
