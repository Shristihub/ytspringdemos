package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.IBrandDTO;
import com.productapp.model.IProductDTO;
import com.productapp.model.IProductInfo;
import com.productapp.model.Product;
import com.productapp.model.ProductBrandDTO;
import com.productapp.model.ProductDetailsDTO;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

	// select productname,price from product where brand=?1
	List<ProductDetailsDTO> findByBrand(String brand);
	
	// select category,brand from product where productname=?1
	ProductBrandDTO findByProductName(String productName);
	
	
	// select category,brand from product where productname=?1
	 IBrandDTO getByProductName(String productName);
	 
	 // select brand, productname from product where category=?1
	  List<IProductDTO> findByCategory(String category);
	  
	// select category,brand from product where productname=?1
	  IProductInfo readByProductName(String productName);
}



























