package com.bookapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class AspringJpaProceduresApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AspringJpaProceduresApplication.class, args);
	}

	@Autowired
	private IBookService bookService;
	@Override
	public void run(String... args) throws Exception {
		int total = bookService.getCountOfBooks("Robin");
		System.out.println(total);
		total = bookService.getBookCount("Robin");
		System.out.println(total);
		total = bookService.getCountByAuthor("Robin");// namedquery
		System.out.println(total);
		
		List<Book> books = bookService.getBookListByAuth("Robin");
		books.forEach(System.out::println);
		
		
		
	}

}
