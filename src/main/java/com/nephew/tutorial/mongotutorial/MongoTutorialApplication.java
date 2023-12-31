package com.nephew.tutorial.mongotutorial;

import java.time.LocalDate;
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
	
	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository, CategoryRepository categoryRepository) {
		return args -> {
			categoryRepository.deleteAll();
			productRepository.deleteAll();
			Category category1 = new Category("Phone", "Technology");			
			Category category2 = new Category("Computer", "Technology");
			categoryRepository.insert(category1);
			categoryRepository.insert(category2);
			Product product1 = new Product("iPhone 11", "Apple Phone", 900, 25999, 3, LocalDate.now().minusMonths(4), Arrays.asList("Good", "Expensive", "Silver"), category1);
			Product product2 = new Product("Galaxy S8", "Android Phone", 500, 185000, 4, LocalDate.now().minusYears(1), Arrays.asList("Great", "Cheap", "Black"), category1);
			Product product3 = new Product("M1 Laptop", "Apple conputer", 1200, 65845, 5, LocalDate.now().minusYears(2), Arrays.asList("Great", "Moderate", "Silver"), category2);
			Product product4 = new Product("LG 29", "Android phone", 1100, 98554, 4, LocalDate.now().minusYears(3), Arrays.asList("Good", "Expensive", "Green"), category1);
			Product product5 = new Product("Acer Pro", "Laptop", 750, 32589, 5, LocalDate.now().minusYears(4), Arrays.asList("Excellent", "Moderate", "Blue"), category1);
			Product product6 = new Product("Dell Desktop", "Windows desktop", 650, 789878, 2, LocalDate.now().minusYears(5), Arrays.asList("Mediocre", "Cheap", "Red"), category2);
			productRepository.insert(product1);
			productRepository.insert(product2);
			productRepository.insert(product3);
			productRepository.insert(product4);
			productRepository.insert(product5);
			productRepository.insert(product6);
		};
	}

}
