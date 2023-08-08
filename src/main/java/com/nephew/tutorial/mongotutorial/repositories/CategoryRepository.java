package com.nephew.tutorial.mongotutorial.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nephew.tutorial.mongotutorial.documents.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
