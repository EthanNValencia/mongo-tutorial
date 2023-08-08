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

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("")
	public ResponseEntity<String> postProduct(@RequestBody Product product) {
		System.out.println("PRODUCT PRINT " + product);
		ResponseEntity<String> response = ResponseEntity.ok(service.save(product));
		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable("id") String id) {
		ResponseEntity<Product> response = ResponseEntity.ok(service.findById(id));
		return response;
	}

	@GetMapping("")
	public ResponseEntity<List<Product>> getAllProducts() {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(service.findAll());
		return response;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
		// ResponseEntity<Void> response = ResponseEntity.ok(service.delete(id));
		service.delete(id);
		return ResponseEntity.accepted().build();
	}

}
