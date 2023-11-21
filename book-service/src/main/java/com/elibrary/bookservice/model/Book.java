package com.elibrary.bookservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "Book")
@Data
public class Book {

	@Id
	@Field(name = "id")
	private Long id;

	@Field(name = "title")
	private String title;

	@Field(name = "author")
	private String author;

	@Field(name = "description")
	private String description;

	@Field(name = "copies")
	private int copies;

	@Field(name = "copies_avaliable")
	private int copiesAvaliable;

	@Field(name = "category")
	private String category;

	@Field(name = "image")
	private String image;

}
