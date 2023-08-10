package com.nephew.tutorial.mongotutorial.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nephew.tutorial.mongotutorial.documents.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findAllByNameIgnoreCase(String name);
	List<Product> findAllByName(String name);
	Product findByName(String name);
	List<Product> findAllByNameStartingWith(String prefix);
	List<Product> findAllByNameEndingWith(String suffix);
}
