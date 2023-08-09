package com.nephew.tutorial.mongotutorial.services;

import java.math.BigDecimal;
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
	
	public List<Product> searchByName(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	
	public List<Product> searchByNameStartingWith(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex("^" + name));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	
	public List<Product> searchByNameEndingWith(String name){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex(name + "$"));
		List<Product> products = template.find(query, Product.class);
		return products;
	}
	
	public List<Product> searchByPriceLt(Integer price){
		Query query = new Query();
		query.addCriteria(Criteria.where("price").lt(price)); // lt is lessthan
		List<Product> products = template.find(query, Product.class);
		//System.out.println("Product Price: " + products.get(0).getPrice());
		return products;
	}
	
	public List<Product> searchByPriceGt(Integer price){
		Query query = new Query();
		query.addCriteria(Criteria.where("price").gt(price)); // gt is greaterthan
		List<Product> products = template.find(query, Product.class);
		//System.out.println("Product Price: " + products.get(0).getPrice());
		return products;
	}
	
	
}
