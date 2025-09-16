package com.adminpanel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.adminpanel.model.Book;

import reactor.core.publisher.Mono;

@Service
public class AdminServiceImpl implements IAdminService {
	
	
	// from this service layer communicate to the other restapi
	// inbuilt class WebCLient
	//autowire WebClient
	@Autowired
	private WebClient webClient;
	@Value("${book-catalog.server.url}")
	private String BASEURL;

	@Override
	public void insertBook(Book book) {
//		http://localhost:8081/book-api/v1/books
		String url = BASEURL + "/book-api/v1/books";
		ResponseEntity<Void> responseEntity =
				webClient.post()
				         .uri(url)
				         .bodyValue(Book.class)
				         .retrieve()
				         .toBodilessEntity()
				         .block();
				
		System.out.println(responseEntity.getStatusCode().value());
	}

	@Override
	public void updateBook(Book book) {
		String url = BASEURL + "/book-api/v1/books";
//		http://localhost:8081/book-api/v1/books		
		webClient.put()
				 .uri(url)
				 .body(Mono.just(book),Book.class)
				 .retrieve()
				 .toBodilessEntity()
				 .block();
	}

	@Override
	public void deleteBookById(int bookId) {
//		http://localhost:8081/book-api/v1/books/bookid/1
		String url = BASEURL + "/book-api/v1/books";
		webClient.delete()
				 .uri(url+"/bookid/{Id}",bookId)
				 .retrieve()
				 .toBodilessEntity()
				 .block();
	}

	@Override
	public List<Book> getAllBooks() {
//		http://localhost:8081/book-api/v1/books
		String url = BASEURL + "/book-api/v1/books";
		ResponseEntity<List<Book>> responseEntity = 
				webClient.get()
				 		.uri(url)
				 		.retrieve()
				 		.toEntityList(Book.class)
				 		.block();
				 
		List<Book> books = responseEntity.getBody();
		return books;
	}

	@Override
	public Book getBookById(int bookId) {
//		http://localhost:8081/book-api/v1/books/bookId?bookId=10
		String url = BASEURL+ "/book-api/v1/books";.concat("/bookId?bookId=")+bookId;
		ResponseEntity<Book> responseEntity = 
				webClient.get()
						 .uri(url+)
						 .retrieve()
						 .toEntity(Book.class)
						 .block();
		Book book = responseEntity.getBody();
		return book;
	}

	@Override
	public List<Book> getBookByAuthor(String mauthor) {
//		http://localhost:8081/book-api/v1/books/author/Kathy
		String url = BASEURL.concat("/author/")+mauthor;
		ResponseEntity<List<Book>>  responseEntity = 
				webClient
				.get()
				.uri(url)
				.retrieve()
				.toEntityList(Book.class)
				.block();
		List<Book> books = responseEntity.getBody();
		return books;
	}
	
	


	



}
