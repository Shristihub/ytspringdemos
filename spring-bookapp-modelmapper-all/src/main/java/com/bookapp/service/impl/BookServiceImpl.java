package com.bookapp.service.impl;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.Author;
import com.bookapp.model.Book;
import com.bookapp.model.BookRequest;
import com.bookapp.model.BookResponse;
import com.bookapp.repository.IBookRepository;
import com.bookapp.service.IBookService;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService{
	
	private final IBookRepository bookRepository;
	private final ModelMapper mapper;

	@Override
	
	public void addBook(BookRequest bookRequest) {
		Book book = mapper.map(bookRequest, Book.class);
		//call the method of repo to save the entity
		book.setIsbn(generateIsbn());
		bookRepository.save(book);
	}

	@Override
	public void updateBook(BookRequest bookRequest) {
		// convert bookRequest object to book entity 
		Book book = mapper.map(bookRequest, Book.class);
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
				mapper.map(book, BookResponse.class);
		return bookResponse;
	}

	@Override
	@Transactional
	public List<BookResponse> getAll() {
		// get the list of book entities from the db
		List<Book> books = bookRepository.findAll();
		// convert  book entity to bookResponse object
		List<BookResponse> bookResponses = books.stream()
			.map(book->mapper.map(book, BookResponse.class))
			.toList();
		return bookResponses;
	}

	@Override
	public List<BookResponse> getByAuthor(String author) {
		
		return null;
	}

	private String generateIsbn() {
		return "ISBN-"+UUID.randomUUID().toString().substring(0, 13);
	}
}
