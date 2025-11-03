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
public class Author {

	@Id
	@GeneratedValue(generator = "author_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "author_gen",sequenceName = "author_seq",initialValue = 100,allocationSize = 1)
    private Integer authorId;

    private String name;
    private String country;

  
}
