package com.nephew.tutorial.mongotutorial.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	private String id;
	private String name;
	private String description;
	private Integer price;
	private Integer quantity;
	private Integer rating;
	private List<String> tags;
	@DBRef
	private Category category;
	
	public Product(String name, String description, Integer price, Integer quantity, Integer rating,
			List<String> tags, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.rating = rating;
		this.tags = tags;
		this.category = category;
	}

	public Product(String id, String name, String description, List<String> tags, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.tags = tags;
		this.category = category;
	}

	public Product(String id, String name, String description, List<String> tags) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.tags = tags;
	}

	public Product(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Product(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Product() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", tags=" + tags
				+ ", category=" + category + "]";
	}

}
