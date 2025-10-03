package com.adminpanel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.adminpanel.feignclients.IBookFeignClient;
import com.adminpanel.model.Book;

@Service
public class AdminServiceImpl implements IAdminService {
	
	//autowire FeignClient
	@Autowired
	private IBookFeignClient bookFeignClient;
	
	@Override
	public void addBook(Book book) {
		ResponseEntity<Void> responseEntity =  bookFeignClient.insertBook(book);
		System.out.println(responseEntity.getStatusCode().value());
	}

	@Override
	public void updateBook(Book book) {
		ResponseEntity<Void> responseEntity =  bookFeignClient.updateOneBook(book);
		System.out.println(responseEntity.getStatusCode().value());
	}

	@Override
	public void deleteBook(int bookId) {
		ResponseEntity<Void> responseEntity = bookFeignClient.deleteBookById(bookId);
		System.out.println(responseEntity.getStatusCode().value());
	}

	@Override
	public List<Book> getAll() {
		ResponseEntity<List<Book>> responseEntity =  bookFeignClient.getAll();
		List<Book> books = responseEntity.getBody();
		return books;
	}

	@Override
	public Book getById(int bookId) {
		ResponseEntity<Book> responseEntity =  bookFeignClient.getById(bookId);
		Book book = responseEntity.getBody();
		return book;
	}

	@Override
	public List<Book> getByAuthor(String author) {
		ResponseEntity<List<Book>> responseEntity =  bookFeignClient.getByAuthor(author);
		List<Book> books = responseEntity.getBody();
		return books;
	}

}














