package com.bookapp.service;

import com.bookapp.model.AuthorDto;

public interface IAuthorService {
	void addAuthor(AuthorDto authorDto);
	void updateAuthor(AuthorDto authorDto);
	void deleteAuthor(int authorId);
	//querying 
	AuthorDto getById(int authorId);

}
