package com.productapp.model;

// projection using interfaces
// should have getter methods for the properties pointing to the columns
// implemantation by jpa during the runtime
public interface IBrandDTO {
	
	String getBrand();
	String getCategory();
}
