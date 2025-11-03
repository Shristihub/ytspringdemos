package com.bookapp.service;

import java.util.List;

import com.bookapp.model.CategoryDto;

public interface ICategoryService {
	void addCategory(CategoryDto categoryDto);
	void updateCategory(CategoryDto categoryDto);
	void deleteCategory(int categoryId);
	//querying 
	CategoryDto getById(int categoryId);
	List<CategoryDto> getAllCategories();

}
