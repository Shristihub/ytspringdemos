package com.adminpanel.service;

import java.util.List;

import com.adminpanel.model.Book;


public interface IAdminService {
	
	void addBook(Book book);
	void updateBook(Book book);
	void deleteBook(int bookId);
	List<Book> getAll();
	Book getById(int bookId);
	
	List<Book> getByAuthor(String author);
	

}
