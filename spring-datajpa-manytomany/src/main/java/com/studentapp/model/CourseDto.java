package com.studentapp.model;

import java.util.List;



public record CourseDto(
	 Integer courseId,
	 String courseName,
	 Mode mode,
	 String category ,// take values from enum web,frontend
	 String duration,
	 CourseLevel courseLevel,
	 String instructor,
	 List<StudentDto> students) {
	
	// create a constructor
	public CourseDto(String courseName,
			 Mode mode,
			 String category ,// take values from enum web,frontend
			 String duration,
			 CourseLevel courseLevel,
			 String instructor) {
		this(null,courseName,mode,category,duration,courseLevel,instructor,null);
	}
	
	
}
