package com.bookapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity 
public class Book {
	@Column(length=30) // similar to varchar(30)
	private String title;
	@Column(length=30)
	private String author;
	@Column(name="cost") // to give a different column name
	private double price;
	@Column(length=30)
	private String category;
	@Id // for primary key
	@GeneratedValue
	@SequenceGenerator(name = "book_gen",sequenceName = "book_seq",initialValue = 1,allocationSize = 1)
	private Integer bookId;
	public Book(String title, String author, double price, String category) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
	}
	
	

}
