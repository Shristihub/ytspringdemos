package com.bookapp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
 

@Entity
@NamedStoredProcedureQuery(
		name = "getBookCountByAuthor",
		procedureName = "get_count_of_books",
		parameters = {
				@StoredProcedureParameter(mode=ParameterMode.IN,name="auth",type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.OUT,name="total",type=Integer.class)
		})
public class Book {
	private String title;
	private String author;
	@Id
	private Integer bookId;
	@Column(name="cost")
	private double price;
	private String category;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, Integer bookId,String author, double price, String category) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer  bookId) {
		this.bookId = bookId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", bookId=" + bookId + ", price=" + price + ", category="
				+ category + "]";
	}
	

}
