package com.bookapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.model.BookRequest;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookcatalogMapstructApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBookcatalogMapstructApplication.class, args);
	}

	@Autowired
	IBookService bookService;

	@Override
	public void run(String... args) throws Exception {
		BookRequest book = new BookRequest("Java in Action","Kathy",900);
		bookService.addBook(book);
		
	}
	
}
