package com.adminpanel.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.adminpanel.model.Book;


// this is the client for bookcatalog service
// the proxy implementation will be provided during the runtime by feign
// this is a declarative client
// just give the name of the service/rest api with which you want to communicate
// if it is between 2 independent restapis, url is mandatory
@FeignClient(name = "bookcatalog-api",url="http://localhost:8081/book-api/v1")
public interface IBookFeignClient {
	
	// add url mapping that is same as that of the service /restapi
	// with which you want to communciate
	
	@PostMapping("/books")
	ResponseEntity<Void> insertBook(@RequestBody Book book);
	@PutMapping("/books")
	ResponseEntity<Void> updateOneBook(@RequestBody Book book);
	
	@DeleteMapping("/books/bookid/{bookId}")
	ResponseEntity<Void> deleteBookById(@PathVariable int bookId);
	@GetMapping("/books")
	ResponseEntity<List<Book>> getAll();
	@GetMapping("/books/bookId")
	ResponseEntity<Book> getById(@RequestParam int bookId);
	@GetMapping("/books/author/{author}")
	ResponseEntity<List<Book>> getByAuthor(@PathVariable String author);
	
}

















