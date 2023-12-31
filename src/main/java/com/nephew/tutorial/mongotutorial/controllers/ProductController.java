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

	private final ProductService productService;	
	private final SearchService searchService;

	public ProductController(ProductService productService, SearchService searchService) {
		super();
		this.productService = productService;
		this.searchService = searchService;
	}

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
		ResponseEntity<List<Product>> response = ResponseEntity.ok(searchService.searchByName(name));
		return response;
	}
	
	@GetMapping("/search/starts-with/{name}")
	public ResponseEntity<List<Product>> searchByNameStartsWith(@PathVariable("name") String name) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(searchService.searchByNameStartingWith(name));
		return response;
	}
	
	@GetMapping("/search/ends-with/{name}")
	public ResponseEntity<List<Product>> searchByNameEndsWith(@PathVariable("name") String name) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(searchService.searchByNameEndingWith(name));
		return response;
	}
	
	@GetMapping("/search/lt/{price}")
	public ResponseEntity<List<Product>> searchByPriceLt(@PathVariable("price") Integer price) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(searchService.searchByPriceLt(price));
		return response;
	}
	
	@GetMapping("/search/gt/{price}")
	public ResponseEntity<List<Product>> searchByPriceGt(@PathVariable("price") Integer price) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(searchService.searchByPriceGt(price));
		return response;
	}
	
	@GetMapping("/search/asc/{fieldname}")
	public ResponseEntity<List<Product>> searchByPriceGt(@PathVariable("fieldname") String fieldName) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(searchService.sortByFieldAsc(fieldName));
		return response;
	}
	
	@GetMapping("/sort-page/{fieldname}")
	public ResponseEntity<List<Product>> sortAndPage(@PathVariable("fieldname") String fieldName) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(searchService.sortAndPageByFieldAsc(fieldName));
		return response;
	}
	
	/*
	@GetMapping("/search/least-recent")
	public ResponseEntity<Product> searchLeastRecentDate() {
		ResponseEntity<Product> response = ResponseEntity.ok(searchService.sortLeastRecentDate());
		return response;
	}
	*/
	
	@GetMapping("/search/most-recent")
	public ResponseEntity<Product> searchMostRecentDate() {
		ResponseEntity<Product> response = ResponseEntity.ok(searchService.sortMostRecentDate());
		return response;
	}
	
	

}
