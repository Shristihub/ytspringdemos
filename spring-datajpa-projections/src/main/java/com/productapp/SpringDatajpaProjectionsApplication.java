package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.IBrandDTO;
import com.productapp.model.IProductInfo;
import com.productapp.model.ProductBrandDTO;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringDatajpaProjectionsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaProjectionsApplication.class, args);
	}
	
	@Autowired
	private IProductService productService;
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("Using DTO as classes");
//		productService.findByBrand("classmate").forEach((productDetails)->{
//			System.out.print(productDetails.getProductName()+"\t");
//			System.out.println(productDetails.getPrice());
//		});
//
//		ProductBrandDTO details = productService.findByProductName("Mobile");
//		System.out.println("Brand "+details.getBrand());
//		System.out.println("Category "+details.getCategory());
//		System.out.println();
//		System.out.println("Using DTO as interfaces");
//		IBrandDTO bdetails = productService.getByProductName("Laptop");
//		System.out.println("Brand "+bdetails.getBrand());
//		System.out.println("Category "+bdetails.getCategory());
//		System.out.println();
//		productService.findByCategory("Gadgets").forEach((productDTO)->{
//			System.out.println("Brand "+productDTO.getBrand());
//			System.out.println("Productname "+productDTO.getProductName());
//		});
//		
		System.out.println("Using Open projection");
		IProductInfo productInfo =  productService.readByProductName("Notebook");
		System.out.println(productInfo.getDetails());
		
 }

}
