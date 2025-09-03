package com.productapp.model;

import org.springframework.beans.factory.annotation.Value;

// open projection
public interface IProductInfo {

	// can have any method name
	// pass the properties that you want to project
	// target refers to the entity
	@Value("#{target.brand+''+target.category}")
	String getDetails();
}
