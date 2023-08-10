package com.nephew.tutorial.mongotutorial;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nephew.tutorial.mongotutorial.documents.Product;
import com.nephew.tutorial.mongotutorial.services.QueryMethodService;
import com.nephew.tutorial.mongotutorial.services.SearchService;

@SpringBootTest
class MongoTutorialApplicationTests {
	@Autowired
	SearchService searchService;
	@Autowired
	QueryMethodService queryMethodService;
	
	@Test
	void contextLoads() {
		
	}
	
	@Test
	void test_QueryMethodService_searchNameContainingAndSortAscByPricePageable() {
		String name = "o";
		List<Product> response = queryMethodService.searchNameContainingAndSortAscByPricePageable(name);
		assertEquals("Dell Desktop", response.get(0).getName());
	}
	
	@Test
	void test_QueryMethodService_searchNameContainingAndSortDescByPricePageable() {
		String name = "o";
		List<Product> response = queryMethodService.searchNameContainingAndSortDescByPricePageable(name);
		assertEquals("M1 Laptop", response.get(0).getName());
	}

}
