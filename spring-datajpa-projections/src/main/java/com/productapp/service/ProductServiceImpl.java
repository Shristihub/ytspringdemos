package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.IBrandDTO;
import com.productapp.model.IProductDTO;
import com.productapp.model.IProductInfo;
import com.productapp.model.ProductBrandDTO;
import com.productapp.model.ProductDetailsDTO;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	
	IProductRepository productRepository;
	
	@Autowired
	public void setProductRepository(IProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<ProductDetailsDTO> findByBrand(String brand) {
		return productRepository.findByBrand(brand);
	}

	@Override
	public ProductBrandDTO findByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}

	@Override
	public IBrandDTO getByProductName(String productName) {
		return productRepository.getByProductName(productName);
	}

	@Override
	public List<IProductDTO> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public IProductInfo readByProductName(String productName) {
		return productRepository.readByProductName(productName);
	}

	

	

	

}
