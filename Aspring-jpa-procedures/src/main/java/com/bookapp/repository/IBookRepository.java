package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    // use procedure name as the method name
	@Procedure
	int get_count_of_books(String author);
	
//	 Using @Procedure with different method name. 
//	 use attributes to pass procedureName
	@Procedure(procedureName = "get_count_of_books")
	int getBookCount(String author);

//	Using @NamedStoredProcedureQuery annotation
    @Procedure(name = "getBookCountByAuthor")
	int getCountByAuthor(@Param("auth") String author);
    
//   Using @Query annotation
    @Query(value ="call get_books_by_author(:author)",nativeQuery = true)
    List<Book> getBookListByAuth(@Param("author") String author);




}


