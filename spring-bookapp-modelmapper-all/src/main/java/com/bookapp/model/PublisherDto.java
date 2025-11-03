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
public class PublisherDto {

    private Integer publisherId;
    private String name;
    private String address;
    @JsonIgnore
    private List<BookResponse> books ;
}
