package com.bookapp.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="books")
public class Category {

	@Id
	@GeneratedValue(generator = "cat_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_gen",sequenceName = "cat_seq",initialValue = 1,allocationSize = 1)
    private Integer categoryId;

    private String categoryName;
    
    @ManyToMany(mappedBy = "categories")
    private List<Book> books = new ArrayList<>();
}
