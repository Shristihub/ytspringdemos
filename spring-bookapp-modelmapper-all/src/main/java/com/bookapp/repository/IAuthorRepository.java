package com.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookapp.model.Author;

public interface IAuthorRepository extends JpaRepository<Author, Integer> {

}
