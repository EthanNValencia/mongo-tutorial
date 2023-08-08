package com.nephew.tutorial.mongotutorial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nephew.tutorial.mongotutorial.documents.Product;
import com.nephew.tutorial.mongotutorial.repositories.ProductRepository;

@SpringBootApplication
public class MongoTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoTutorialApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepo) {
		return args -> {
			Product product = new Product("iPhone", "Smart Phone");
			productRepo.insert(product);
		};
	}

}
