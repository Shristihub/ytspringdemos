package com.bookapp.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "books")
public class CategoryDto {

    private Integer categoryId;
    private String categoryName;
    @JsonIgnore
    private List<BookResponse> books = new ArrayList<>();
}
