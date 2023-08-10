package com.nephew.tutorial.mongotutorial.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nephew.tutorial.mongotutorial.documents.Product;
import com.nephew.tutorial.mongotutorial.repositories.ProductRepository;

@Service
public class QueryMethodService {
	
	private final ProductRepository productRepository;
	
	public QueryMethodService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public List<Product> searchByName(String name) {
		return productRepository.findAllByNameIgnoreCase(name);
	}

	public List<Product> searchByNameStartingWith(String name) {
		return productRepository.findAllByNameStartingWith(name);
	}

	public List<Product> searchByNameEndingWith(String name) {
		return productRepository.findAllByNameEndingWith(name);
	}

	public List<Product> searchByPriceLt(Integer price) {
		return null;
	}

	public List<Product> searchByPriceGt(Integer price) {
		return null;
	}

	public List<Product> sortByFieldAsc(String fieldName) {
		return null;
	}
	
	public List<Product> sortAndPageByFieldAsc(String fieldName) {
		return null;
	}
	
	public Product sortMostRecentDate() {
		return null;
	}
}
