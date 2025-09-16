package com.adminpanel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminpanel.model.Book;
import com.adminpanel.service.IAdminService;

@RestController
@RequestMapping("/dashboard-api/v1")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	
	
//	http://localhost:8083/dashboard-api/v1/admin/books
	@PostMapping("/admin/books")
	ResponseEntity<Void> insertBook(@RequestBody Book book){
		adminService.insertBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
//	http://localhost:8083/dashboard-api/v1/admin/books
	@PutMapping("/admin/books")
	ResponseEntity<Void> updateBook(@RequestBody Book book){
		adminService.updateBook(book);
		return ResponseEntity.status(202).build();
	}
	
//	http://localhost:8083/dashboard-api/v1/admin/books/bookId/1
	@DeleteMapping("/admin/books/bookId/{bookId}")
	ResponseEntity<Void>  deleteBookById(@PathVariable int bookId){
		adminService.deleteBookById(bookId);
		return ResponseEntity.noContent().build();
		
	}
//	http://localhost:8083/dashboard-api/v1/admin/books
	@GetMapping("/admin/books")
	ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books = adminService.getAllBooks();
		return ResponseEntity.ok(books);
		
	}
//	http://localhost:8083/dashboard-api/v1/admin/books/bookId/1
	@GetMapping("/admin/books/bookId/{bookId}")
	ResponseEntity<Book> getBookById(@PathVariable int bookId){
		Book book = adminService.getBookById(bookId);
		return ResponseEntity.ok(book);
	}
	
//	http://localhost:8083/dashboard-api/v1/admin/books/author/Kathy
	@GetMapping("/admin/books/author/{author}")
	ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String author){
		List<Book> books = adminService.getBookByAuthor(author);
		return ResponseEntity.ok(books);
	}
	
	

	
	
	
}
