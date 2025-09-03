package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.ProductDto;
import com.productapp.service.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/product-api")
@Tag(name = "Product Controller", description ="has rest end points of product catalog")
public class ProductController {

	@Autowired
	IProductService productService;
	
	@Operation(operationId = "getAllProducts",
			   summary = "Getting list of products",
			   description = "This rest end point is used to return a list of products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					     description=" returns a list of products",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = ProductDto.class)) )
	})
	@GetMapping("/products")
	ResponseEntity<List<ProductDto>> getAll(){
		List<ProductDto> productDtos = productService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(productDtos);
	}
	
	@Operation(operationId = "createProduct",
			   summary = "Adding  a product",
			   description = "This restend point is used to create a product")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201",
					     description="creates and returns the saved product",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = ProductDto.class)) )
	})
	@PostMapping("/products")
	ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
		 ProductDto savedproductDto = productService.addProduct(productDto);
		 return ResponseEntity.status(HttpStatus.CREATED).body(savedproductDto);
	}
	@PutMapping("/products/{productId}")
	ResponseEntity<ProductDto> updateProduct(@PathVariable int productId, @RequestBody ProductDto product) {
		ProductDto productDto = productService.updateProduct(productId,product);
		 return ResponseEntity.ok(productDto);
	}
	@DeleteMapping("/products/{productId}")
	void deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
	}
	@Operation(operationId = "getProductBy Id",
			   summary = "Getting one product by Id",
			   description = "This restend point is used return a product by id",
			   parameters = {
					   @Parameter(name = "productId",
							      required = true,
							      description = "pass productId")
			   }
			)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					     description="returns one product",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = ProductDto.class)) )
	})
	@GetMapping("/products/productid/{productId}")
	@Cacheable(cacheNames = "products",key = "#id")
	ResponseEntity<ProductDto> getById(@PathVariable int productId) {
		ProductDto productDto = productService.getById(productId);
		return ResponseEntity.ok(productDto);
		
	}
	@GetMapping("/products/brand/{brand}")
	ResponseEntity<List<ProductDto>> getByBrand(@PathVariable String brand){
		List<ProductDto> productDtos = productService.getByBrand(brand);
		return ResponseEntity.status(HttpStatus.OK).body(productDtos);
	}
	@GetMapping("/products/category/{category}")
	ResponseEntity<List<ProductDto>> getByCategory(@PathVariable String category){
		List<ProductDto> productDtos = productService.getByCategory(category);
		return ResponseEntity.status(HttpStatus.OK).body(productDtos);
	}
}


