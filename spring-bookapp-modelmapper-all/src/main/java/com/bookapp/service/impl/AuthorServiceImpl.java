package com.bookapp.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bookapp.model.Author;
import com.bookapp.model.AuthorDto;
import com.bookapp.repository.IAuthorRepository;
import com.bookapp.service.IAuthorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements IAuthorService{
	
	private final IAuthorRepository repository;
	private final ModelMapper mapper;

	@Override
	public void addAuthor(AuthorDto authorDto) {
		Author author= mapper.map(authorDto, Author.class);
		repository.save(author);
	}

	@Override
	public void updateAuthor(AuthorDto authorDto) {
		Author author= mapper.map(authorDto, Author.class);
		repository.save(author);
		
	}

	@Override
	public void deleteAuthor(int authorId) {
		repository.deleteById(authorId);
		
	}

	@Override
	public AuthorDto getById(int authorId) {
		Author author = repository.findById(authorId).get();
		return mapper.map(author, AuthorDto.class);
	}

}






