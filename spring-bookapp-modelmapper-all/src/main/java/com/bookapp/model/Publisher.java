package com.bookapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "books")
public class Publisher {

	@Id
	@GeneratedValue(generator = "pub_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "pub_gen",sequenceName = "pub_seq",initialValue = 50,allocationSize = 1)
    private Integer publisherId;

    private String name;
    private String address;
    @OneToMany(mappedBy = "publisher")//fetch=FetchType.EAGER)
    private List<Book> books;
}
