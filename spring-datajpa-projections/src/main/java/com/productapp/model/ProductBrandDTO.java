package com.productapp.model;

// projection using DTO as class
public class ProductBrandDTO {
	String brand;
	String category;
	public ProductBrandDTO(String brand, String category) {
		super();
		this.brand = brand;
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public String getCategory() {
		return category;
	}
	@Override
	public String toString() {
		return "ProductBrandDTO [brand=" + brand + ", category=" + category + "]";
	}
	
	
	

}
