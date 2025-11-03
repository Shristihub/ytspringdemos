package com.studentapp.service;

import java.util.List;

import com.studentapp.model.CourseDto;

public interface ICourseService {

	void addCourse(CourseDto courseDto);
	void updateCourse(CourseDto courseDto);
	void deleteCourse(int courseId);
	CourseDto getById(int courseId);
	
	List<CourseDto> getAll();
	
	
	
	
}
