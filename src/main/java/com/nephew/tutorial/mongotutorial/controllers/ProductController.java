package com.nephew.tutorial.mongotutorial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nephew.tutorial.mongotutorial.documents.Product;
import com.nephew.tutorial.mongotutorial.services.ProductService;
import com.nephew.tutorial.mongotutorial.services.SearchService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	SearchService searchService;

	@PostMapping("")
	public ResponseEntity<String> postProduct(@RequestBody Product product) {
		System.out.println("PRODUCT PRINT " + product);
		ResponseEntity<String> response = ResponseEntity.ok(productService.save(product));
		return response;
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") String id) {
		ResponseEntity<Product> response = ResponseEntity.ok(productService.findById(id));
		return response;
	}

	@GetMapping("")
	public ResponseEntity<List<Product>> getAllProducts() {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(productService.findAll());
		return response;
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
		// ResponseEntity<Void> response = ResponseEntity.ok(service.delete(id));
		productService.delete(id);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/search/is/{name}")
	public ResponseEntity<List<Product>> searchByName(@PathVariable("name") String name) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(searchService.findByName(name));
		return response;
	}
	
	@GetMapping("/search/starts-with/{name}")
	public ResponseEntity<List<Product>> searchByNameStartsWith(@PathVariable("name") String name) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(searchService.findByNameStartingWith(name));
		return response;
	}
	
	@GetMapping("/search/ends-with/{name}")
	public ResponseEntity<List<Product>> searchByNameEndssWith(@PathVariable("name") String name) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(searchService.findByNameEndingWith(name));
		return response;
	}

}
