package com.bookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
	private String title;
	private String author;
	private double price;
	private String category;
	private Integer bookId;
	
	
	

}
