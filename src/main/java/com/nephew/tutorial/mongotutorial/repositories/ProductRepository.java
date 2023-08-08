package com.nephew.tutorial.mongotutorial.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nephew.tutorial.mongotutorial.documents.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
