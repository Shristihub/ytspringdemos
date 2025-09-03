package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
	@Column(length = 30)
	private String productName;
	@Id
	@GeneratedValue
	private Integer productId;
	@Column(length = 20)
	private String brand;
	@Column(length = 20)
	private String category;
	@Column(name="cost") // to give a different column name
	private double price;
	public Product(String productName, String brand, String category, double price) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}
	
	
	
	
	

}
