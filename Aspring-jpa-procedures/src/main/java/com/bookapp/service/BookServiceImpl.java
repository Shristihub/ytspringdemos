package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService{
	
	
  private IBookRepository bookRepository;

  	@Autowired
	public void setBookRepository(IBookRepository bookRepository) {
	this.bookRepository = bookRepository;
}

	@Override
	public int getCountOfBooks(String author) {
		return bookRepository.get_count_of_books(author);
	}

	@Override
	public int getBookCount(String author) {
		return bookRepository.getBookCount(author);
	}

	@Override
	@Transactional
	public int getCountByAuthor(String author) {
		return bookRepository.getCountByAuthor(author);
	}

	@Override
	public List<Book> getBookListByAuth(String author) {
		return bookRepository.getBookListByAuth(author);
	}
	
	

}
