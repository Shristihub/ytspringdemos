package com.bookapp.service;

import java.util.List;

import com.bookapp.model.Publisher;
import com.bookapp.model.PublisherDto;

public interface IPublisherService {
	void addPublisher(PublisherDto PublisherDto);
	void updatePublisher(PublisherDto PublisherDto);
	void deletePublisher(int PublisherId);
	//querying 
	PublisherDto getById(int PublisherId);
	List<PublisherDto> getAllPublishers();

}
