package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.model.CourseLevel;
import com.studentapp.model.Mode;
import com.studentapp.model.StudentDto;
import com.studentapp.repository.IStudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {

	
	@Autowired
	private final IStudentRepository studentRepository;

	@Override
	public void addStudent(StudentDto studentDto) {
		
	}

	@Override
	public void updateStudent(StudentDto studentDto) {
		

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}

	@Override
	public StudentDto getById(int studentId) {
//		Student student = studentRepository.findById(studentId)
//			.orElseThrow(()-> new RuntimeException("invalid Id"));
//		return mapper.map(student, StudentDto.class);
		return null;
	}

	@Override
	public List<StudentDto> getAll() {
		return null;
	}

	@Override
	public List<StudentDto> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getByCourseName(String courseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getByCourseNameAndLevel(String courseName, CourseLevel level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDto> getByCourseNameAndMode(String courseName, Mode mode) {
		// TODO Auto-generated method stub
		return null;
	}

}
