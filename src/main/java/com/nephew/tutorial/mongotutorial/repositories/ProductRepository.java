package com.nephew.tutorial.mongotutorial.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nephew.tutorial.mongotutorial.documents.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findAllByNameIgnoreCase(String name);

	List<Product> findAllByName(String name);

	Product findByName(String name);

	List<Product> findAllByNameStartingWith(String prefix);

	List<Product> findAllByNameEndingWith(String suffix);

	List<Product> findAllByNameContaining(String infix);

	List<Product> findAllByNameContainingIgnoreCase(String infix);
	
	// By default, order is in ascending order, so I have to specify Desc for descending order. 
	List<Product> findAllByNameContainingIgnoreCaseOrderByPriceDesc(String fieldName);
	
	List<Product> findAllByNameContainingIgnoreCaseOrderByPriceDesc(String fieldName, Pageable pageable);
	
	List<Product> findAllByNameContainingIgnoreCaseOrderByPriceAsc(String fieldName, Pageable pageable);

	
	List<Product> findByPrice(Integer price); // Finds exact match

	List<Product> findByPriceLessThan(Integer price);

	List<Product> findByPriceLessThanEqual(Integer price);

	List<Product> findByPriceGreaterThan(Integer price);
	
	List<Product> findByPriceBetween(Integer lowPrice, Integer highPrice);

	List<Product> findByDateLessThanEqual(LocalDate date);
}
