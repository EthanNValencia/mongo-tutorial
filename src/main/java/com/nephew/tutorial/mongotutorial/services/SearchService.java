package com.nephew.tutorial.mongotutorial.services;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.nephew.tutorial.mongotutorial.documents.Product;

@Service
public class SearchService {
	private final MongoTemplate template;

	public SearchService(MongoTemplate template) {
		super();
		this.template = template;
	}
	
	public List<Product> findByName(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	
	public List<Product> findByNameStartingWith(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex("^" + name));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	
	public List<Product> findByNameEndingWith(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex(name + "$"));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	
	
}
