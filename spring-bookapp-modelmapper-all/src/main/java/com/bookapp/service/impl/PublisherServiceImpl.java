package com.bookapp.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.Book;
import com.bookapp.model.BookResponse;
import com.bookapp.model.Publisher;
import com.bookapp.model.PublisherDto;
import com.bookapp.repository.IPublisherRepository;
import com.bookapp.service.IPublisherService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublisherServiceImpl implements IPublisherService{
	
	private final IPublisherRepository repository;
	private final ModelMapper mapper;

	@Override
	public void addPublisher(PublisherDto publisherDto) {
		Publisher publisher= mapper.map(publisherDto, Publisher.class);
		repository.save(publisher);
	}

	@Override
	public void updatePublisher(PublisherDto publisherDto) {
		Publisher publisher= mapper.map(publisherDto, Publisher.class);
		repository.save(publisher);
		
	}

	@Override
	public void deletePublisher(int publisherId) {
		repository.deleteById(publisherId);
		
	}

	@Override
	@Transactional
	public PublisherDto getById(int publisherId) {
		Publisher publisher = repository.findById(publisherId).get();
		return mapper.map(publisher, PublisherDto.class);
	}

	@Override
	@Transactional
	public List<PublisherDto> getAllPublishers() {
		List<Publisher> publishers = repository.findAll();
		return publishers.stream()
				.map(publisher->mapper.map(publisher, PublisherDto.class))
				.toList();
	}


}






