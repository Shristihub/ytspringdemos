package com.bookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Integer reviewId;
    private String reviewerName;
    private String comment;
    private int rating; //1-5

}