package com.nephew.tutorial.mongotutorial.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nephew.tutorial.mongotutorial.documents.Product;
import com.nephew.tutorial.mongotutorial.services.QueryMethodService;

@RestController
@RequestMapping("/api/v1/query-products")
public class QueryMethodController {

	private final QueryMethodService queryMethodService;

	public QueryMethodController(QueryMethodService queryMethodService) {
		super();
		this.queryMethodService = queryMethodService;
	}

	@GetMapping("/search/is/{name}")
	public ResponseEntity<List<Product>> searchByName(@PathVariable("name") String name) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(queryMethodService.searchByName(name));
		return response;
	}

	@GetMapping("/search/starts-with/{name}")
	public ResponseEntity<List<Product>> searchByNameStartsWith(@PathVariable("name") String name) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(queryMethodService.searchByNameStartingWith(name));
		return response;
	}

	@GetMapping("/search/ends-with/{name}")
	public ResponseEntity<List<Product>> searchByNameEndsWith(@PathVariable("name") String name) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(queryMethodService.searchByNameEndingWith(name));
		return response;
	}

	@GetMapping("/search/lt/{price}")
	public ResponseEntity<List<Product>> searchByPriceLt(@PathVariable("price") Integer price) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(queryMethodService.searchByPriceLt(price));
		return response;
	}

	@GetMapping("/search/gt/{price}")
	public ResponseEntity<List<Product>> searchByPriceGt(@PathVariable("price") Integer price) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(queryMethodService.searchByPriceGt(price));
		return response;
	}

	@GetMapping("/search/asc/{fieldname}")
	public ResponseEntity<List<Product>> searchByPriceGt(@PathVariable("fieldname") String fieldName) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(queryMethodService.sortByFieldAsc(fieldName));
		return response;
	}

	@GetMapping("/sort-page/{fieldname}")
	public ResponseEntity<List<Product>> sortAndPage(@PathVariable("fieldname") String fieldName) {
		ResponseEntity<List<Product>> response = ResponseEntity.ok(queryMethodService.sortAndPageByFieldAsc(fieldName));
		return response;
	}

	@GetMapping("/search/most-recent")
	public ResponseEntity<Product> searchMostRecentDate() {
		ResponseEntity<Product> response = ResponseEntity.ok(queryMethodService.sortMostRecentDate());
		return response;
	}

}
