package com.bookapp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.mapper.IBookMapper;
import com.bookapp.model.Book;
import com.bookapp.model.BookRequest;
import com.bookapp.model.BookResponse;
import com.bookapp.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService{
	
	@Autowired
	private IBookRepository bookRepository;
	
	@Autowired
	private IBookMapper mapper;

	@Override
	public void addBook(BookRequest bookRequest) {
		// convert bookRequest object to book entity 
		Book book = mapper.toEntity(bookRequest);
		//call the method of repo to save the entity
		book.setIsbn(generateIsbn());
		bookRepository.save(book);
	}

	@Override
	public void updateBook(BookRequest bookRequest) {
		// convert bookRequest object to book entity 
		Book book = mapper.toEntity(bookRequest);
		//call the method of repo to save the entity
		bookRepository.save(book);
		
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}

	@Override
	public BookResponse getById(int bookId) {
		// get the book entity from the db
		Book book = bookRepository.findById(bookId).get();
		// convert  book entity to bookResponse object
		BookResponse bookResponse =  
				mapper.toDto(book);
		return bookResponse;
	}

	@Override
	public List<BookResponse> getAll() {
		// get the list of book entities from the db
		List<Book> books = bookRepository.findAll();
		// convert  book entity to bookResponse object
		List<BookResponse> bookResponses = books.stream()
			.map(book->mapper.toDto(book))
			.toList();
		return bookResponses;
	}

	@Override
	public List<BookResponse> getByAuthor(String author) {
		// get the list of book entities from the db
		List<Book> books = bookRepository.findByAuthor(author);
		// convert  book entity to bookResponse object
		List<BookResponse> bookResponses = books.stream()
			.map(book->mapper.toDto(book))
			.toList();
		return bookResponses;
	}

	private String generateIsbn() {
		return "ISBN-"+UUID.randomUUID().toString().substring(0, 13);
	}
}
