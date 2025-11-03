package com.bookapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.bookapp.model.Book;
import com.bookapp.model.BookRequest;
import com.bookapp.model.BookResponse;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IBookMapper {
	BookResponse toDto(Book book);
	Book toEntity(BookRequest request);

}
