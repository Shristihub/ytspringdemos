package com.productapp.service;

import java.util.List;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.ProductDto;

public interface IProductService {

	// crud operation
	ProductDto addProduct(ProductDto product);
	ProductDto updateProduct(int productId, ProductDto product);
	void deleteProduct(int productId);
	
	List<ProductDto> getAll();
	ProductDto getById(int productId) throws ProductNotFoundException;
	
	//methods to call derived queries
	List<ProductDto> getByCategory(String category)throws ProductNotFoundException;
	List<ProductDto> getByBrand(String brand)throws ProductNotFoundException;
	
	
	
	
	
	
	
	
	
	
	
}
