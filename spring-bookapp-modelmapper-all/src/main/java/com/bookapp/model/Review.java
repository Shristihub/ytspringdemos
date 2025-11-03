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
public class Review {

	@Id
	@GeneratedValue(generator = "review_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "review_gen",sequenceName = "review_seq",initialValue = 50,allocationSize = 1)
    private Integer reviewId;
    private String reviewerName;
    private String comment;
    private int rating; //1-5

}