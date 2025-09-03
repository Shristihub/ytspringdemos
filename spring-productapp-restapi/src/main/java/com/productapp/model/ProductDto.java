package com.productapp.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(name = "ProductDto class")
public class ProductDto {
	@Schema(name = "productName", description = "enter a string value")
	private String productName;
	@Schema(name = "productId", description = "enter a integer value")
	private Integer productId;
	private String brand;
	private String category;
	private double price;
	public ProductDto(String productName, String brand, String category, double price) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}
	
	
	
	
	

}
