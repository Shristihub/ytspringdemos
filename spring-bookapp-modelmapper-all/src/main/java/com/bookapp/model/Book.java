package com.bookapp.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private String title;
	private double price;
	private String isbn;
	@Id
	@GeneratedValue(generator = "book_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "book_gen",sequenceName = "book_seq",initialValue = 1,allocationSize = 1)
	private Integer bookId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id") // to provide a diff column for th forign key
    private BookDetail bookDetail;

	@ManyToOne //many books written by one author
	@JoinColumn(name = "author_id")
	private Author author;

	@ManyToOne //many books published by one publisher
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	// one book having many reviews
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

	// one book in many categories
	@ManyToMany
	@JoinTable(name = "book_category", 
	           joinColumns = 
	            @JoinColumn(name = "book_id"), 
	            inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories = new ArrayList<>();

	public Book(String title, double price, String isbn, Author author, Publisher publisher, BookDetail bookDetail,
			List<Category> categories) {
		this.title = title;
		this.price = price;
		this.isbn = isbn;
		this.author = author;
		this.publisher = publisher;
		this.bookDetail = bookDetail;
		this.categories = categories;
	}
}
