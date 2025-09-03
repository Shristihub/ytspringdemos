package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.productapp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private final IProductRepository productRepository;
	private final ModelMapper mapper;

	

	@Override
	public ProductDto addProduct(ProductDto productdto) {
		Product savedProduct = productRepository.save(mapper.map(productdto, Product.class));
		return mapper.map(savedProduct,ProductDto.class);

	}

	@Override
	public ProductDto updateProduct(int productId, ProductDto productdto) {
		Product updatedProduct = productRepository.save(mapper.map(productdto, Product.class));
		return mapper.map(updatedProduct,ProductDto.class);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public List<ProductDto> getAll() {
		List<Product> products =  productRepository.findAll();
		return products.stream().map(product->mapper.map(product, ProductDto.class)).toList();
		
	
	}

	@Override
	public ProductDto getById(int productId) throws ProductNotFoundException {
		Optional<Product> productOpt = productRepository.findById(productId); // returns an optional
		Product product = productOpt.orElseThrow(() -> new ProductNotFoundException("invalid Id"));
		return mapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getByCategory(String category) {
		List<Product> products = productRepository.findByCategory(category);
		if (products.isEmpty())
			throw new ProductNotFoundException("no products in this category");
		return products.stream().map(product->mapper.map(product, ProductDto.class)).toList();
	}

	@Override
	public List<ProductDto> getByBrand(String brand) {
		List<Product> products = productRepository.readByBrand(brand);
		if (products.isEmpty())
			throw new ProductNotFoundException("no products in this category");
		return products.stream().map(product->mapper.map(product, ProductDto.class)).toList();

	}

}
