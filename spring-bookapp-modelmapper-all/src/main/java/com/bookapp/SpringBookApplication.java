package com.bookapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.AuthorDto;
import com.bookapp.model.BookDetailDto;
import com.bookapp.model.BookRequest;
import com.bookapp.model.CategoryDto;
import com.bookapp.model.PublisherDto;
import com.bookapp.model.ReviewDto;
import com.bookapp.service.IAuthorService;
import com.bookapp.service.IBookService;
import com.bookapp.service.ICategoryService;
import com.bookapp.service.IPublisherService;

@SpringBootApplication
public class SpringBookApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookApplication.class, args);
	}
 
	@Autowired
	private IBookService bookService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IAuthorService authorService;
	@Autowired
	private IPublisherService publisherService;

	@Override
	public void run(String... args) throws Exception {
		
//		//manytoone
//		AuthorDto authorDto1 = new AuthorDto(null,"Shri", "India");
//		authorService.addAuthor(authorDto1);
//		AuthorDto authorDto2 = new AuthorDto(null,"Priya", "India");
//		authorService.addAuthor(authorDto2);
//		
//		//manytoone
//		PublisherDto publisher1 = new PublisherDto(null,"Apple Publishers", "India", null);
//		publisherService.addPublisher(publisher1);
//		PublisherDto publisher2 = new PublisherDto(null,"Orange Publishers", "India", null);
//		publisherService.addPublisher(publisher2);
//		
//		//manytomany
//		CategoryDto category1 = new CategoryDto(null,"Fiction",null);
//		categoryService.addCategory(category1);
//		CategoryDto category2 = new CategoryDto(null,"Tech",null);
//		categoryService.addCategory(category2);
		
		//one to one
		BookDetailDto bookDetailDto = new BookDetailDto(null,"English", 300, 2022);
		
		//one to many
		ReviewDto reviewDto1 = new ReviewDto(null, "Anna", "Good", 4);
		ReviewDto reviewDto2 = new ReviewDto(null, "Jo", "ok", 3);
		ReviewDto reviewDto3 = new ReviewDto(null, "Jacob", "Nice book", 4);
		List<ReviewDto> reviews = Arrays.asList(reviewDto1,reviewDto2,reviewDto3);
		
		//many to one
		PublisherDto publisherDto = publisherService.getById(50);
		AuthorDto authorDto = authorService.getById(100);
		
		//many to many
		CategoryDto categoryDto1 = categoryService.getById(1);
		CategoryDto categoryDto2 = categoryService.getById(2);
		List<CategoryDto> categories = Arrays.asList(categoryDto1,categoryDto2);
		
	   BookRequest bookRequest = new BookRequest("The Atom theory", 800, bookDetailDto, authorDto, publisherDto, reviews, categories);
//	   bookService.addBook(bookRequest);
	   System.out.println();
//	   bookService.getAll().forEach(System.out::println);
//	   System.out.println();
//	   
//	   publisherService.getAllPublishers().forEach(System.out::println);
//	   System.out.println();
//	   categoryService.getAllCategories().forEach(System.out::println);
//	   
	  
	   
	  
	   
	   
	 
	}
}








