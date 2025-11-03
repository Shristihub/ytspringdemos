package com.bookapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDetailDto {

    private Integer detailId;
    private String language;
    private int pages;
    private int yearPublished;

  
}