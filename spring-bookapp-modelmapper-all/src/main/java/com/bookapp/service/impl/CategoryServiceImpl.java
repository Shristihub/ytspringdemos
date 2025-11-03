package com.bookapp.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bookapp.model.Category;
import com.bookapp.model.CategoryDto;
import com.bookapp.model.Publisher;
import com.bookapp.model.PublisherDto;
import com.bookapp.repository.ICategoryRepository;
import com.bookapp.service.ICategoryService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
	
	private final ICategoryRepository repository;
	private final ModelMapper mapper;

	@Override
	public void addCategory(CategoryDto categoryDto) {
		Category category= mapper.map(categoryDto, Category.class);
		repository.save(category);
	}

	@Override
	public void updateCategory(CategoryDto categoryDto) {
		Category category= mapper.map(categoryDto, Category.class);
		repository.save(category);
	}

	@Override
	public void deleteCategory(int categoryId) {
		repository.deleteById(categoryId);

	}

	@Override
	@Transactional
	public CategoryDto getById(int categoryId) {
		Category category = repository.findById(categoryId).get();
		return mapper.map(category, CategoryDto.class);
	}

	@Override
	@Transactional
	public List<CategoryDto> getAllCategories() {
		List<Category> categories = repository.findAll();
		return categories.stream()
				.map(category->mapper.map(category, CategoryDto.class))
				.toList();
	}

}






