package com.studentapp.service;

import java.util.List;

import com.studentapp.model.CourseLevel;
import com.studentapp.model.Mode;
import com.studentapp.model.StudentDto;

public interface IStudentService {

	void addStudent(StudentDto studentDto);
	void updateStudent(StudentDto studentDto);
	void deleteStudent(int studentId);
	StudentDto getById(int studentId);
	
	List<StudentDto> getAll();
	List<StudentDto> getByCity(String city);
	List<StudentDto> getByCourseName(String courseName);
	List<StudentDto> getByCourseNameAndLevel(String courseName,CourseLevel level);
	List<StudentDto> getByCourseNameAndMode(String courseName,Mode mode);
	
	
	
	
}
