package com.productapp.service;

import java.util.List;

import com.productapp.model.IBrandDTO;
import com.productapp.model.IProductDTO;
import com.productapp.model.IProductInfo;
import com.productapp.model.ProductBrandDTO;
import com.productapp.model.ProductDetailsDTO;

public interface IProductService {
	// Projection using DTO as class
	List<ProductDetailsDTO> findByBrand(String brand);
	ProductBrandDTO findByProductName(String productName);
	
	// projection using DTO as interfaces
	 IBrandDTO getByProductName(String productName);
	 List<IProductDTO> findByCategory(String category);
	 
	 // open projection using SpEL
	 IProductInfo readByProductName(String productName);
}
