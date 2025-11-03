package com.bookapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetail {

	@Id
	@GeneratedValue(generator = "bookdetail_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "bookdetail_gen",sequenceName = "bookdetail_seq",initialValue = 10,allocationSize = 1)
    private Integer detailId;

    private String language;
    private int pages;
    private int yearPublished;

  
}