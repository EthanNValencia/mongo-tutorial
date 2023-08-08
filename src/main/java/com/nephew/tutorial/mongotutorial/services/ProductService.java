package com.nephew.tutorial.mongotutorial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nephew.tutorial.mongotutorial.documents.Product;
import com.nephew.tutorial.mongotutorial.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public String save(Product product) {
		Product savedProduct = repo.save(product);
		return savedProduct.getId();
	}
	
	public Product findById(String id) {
		Optional<Product> product =  repo.findById(id);
		return product.get();
	}
	
	public List<Product> findAll() {
		List<Product> productList = repo.findAll();
		return productList;
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
}
