package com.nephew.tutorial.mongotutorial;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nephew.tutorial.mongotutorial.documents.Category;
import com.nephew.tutorial.mongotutorial.documents.Product;
import com.nephew.tutorial.mongotutorial.repositories.CategoryRepository;
import com.nephew.tutorial.mongotutorial.repositories.ProductRepository;

@SpringBootApplication
public class MongoTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoTutorialApplication.class, args);
	}
	
	// @Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepo, CategoryRepository categoryRepository) {
		return args -> {
			Category category1 = new Category("Phone", "Technology");			
			Category category2 = new Category("Computer", "Technology");
			// categoryRepository.insert(category1);
			// categoryRepository.insert(category2);
			Product product1 = new Product("iPhone 11", "Apple Phone", BigDecimal.valueOf(900), 25999, 3, Arrays.asList("Buenos Aires", "Córdoba", "La Plata"), category1);
			
			productRepo.insert(product1);
		};
	}

}
