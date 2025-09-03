package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.BookDto;

public interface IBookService {

	void addBook(BookDto book);
	void updateBook(BookDto book);
	void deleteBook(int bookId);
	List<BookDto> getAll();
	BookDto getById(int bookId)throws BookNotFoundException;;
	
	List<BookDto> getByAuthor(String author)throws BookNotFoundException;
	
	
	
}
