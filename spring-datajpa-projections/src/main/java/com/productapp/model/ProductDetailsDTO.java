package com.productapp.model;

// should have properties that are pointing to the column in the database
// should have the same instance variable like the domain model
// should have ONLY parameterized constr for these instance variables
//should have ONLY getter methods for these instance variables
//  should have a toString method
public class ProductDetailsDTO {
	String productName;
	double price;

	public ProductDetailsDTO(String productName, double price) {
		super();
		this.productName = productName;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "ProductDetailsDTO [productName=" + productName + ", price=" + price + "]";
	}

}
