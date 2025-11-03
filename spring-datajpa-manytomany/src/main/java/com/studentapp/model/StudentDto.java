package com.studentapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDto {
	private Integer studentId;
	private String studentName;
	private String department;
	private String city;
	private List<CourseDto> courses;
	
	
	
	

}
