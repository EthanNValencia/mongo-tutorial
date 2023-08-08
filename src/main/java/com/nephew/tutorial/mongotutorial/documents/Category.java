package com.nephew.tutorial.mongotutorial.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {

	@Id
	private String id;
	private String name;
	private String type;

	public Category(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Category(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public Category() {
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}
