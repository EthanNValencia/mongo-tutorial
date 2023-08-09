package com.nephew.tutorial.mongotutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nephew.tutorial.mongotutorial.services.SearchService;

@SpringBootTest
class MongoTutorialApplicationTests {
	
	@Autowired
	SearchService searchService;

	@Test
	void contextLoads() {
		
	}

}
