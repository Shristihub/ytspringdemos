package com.bookapp.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

	private String title;
	private double price;
    private BookDetailDto bookDetail;
	private AuthorDto author;
	private PublisherDto publisher;
    private List<ReviewDto> reviews = new ArrayList<>();
	private List<CategoryDto> categories = new ArrayList<>();
	
	
}
