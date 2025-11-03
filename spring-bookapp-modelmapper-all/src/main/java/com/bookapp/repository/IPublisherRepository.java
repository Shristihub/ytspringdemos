package com.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPublisherRepository extends JpaRepository<com.bookapp.model.Publisher, Integer> {

}
