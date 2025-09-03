package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Book;

public interface IBookService {
	int getCountOfBooks(String author);
	int getBookCount(String author);
	int getCountByAuthor(String author);
	List<Book> getBookListByAuth(String author);
}
