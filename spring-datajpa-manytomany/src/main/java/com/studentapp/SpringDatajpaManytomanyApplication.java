package com.studentapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Category;
import com.studentapp.model.CourseDto;
import com.studentapp.model.CourseLevel;
import com.studentapp.model.Mode;
import com.studentapp.model.StudentDto;
import com.studentapp.service.ICourseService;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringDatajpaManytomanyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatajpaManytomanyApplication.class, args);
	}

	@Autowired
	private IStudentService studentService;
	@Autowired
	private ICourseService courseService;

	@Override
	public void run(String... args) throws Exception {
		CourseDto courseDto = new CourseDto("Spring", Mode.ONLINE, Category.BE.getCategory(), "3 months",
				CourseLevel.BEGINNER, "Shri");
		// getter method using record
//		System.out.println(courseDto.courseName());
		courseService.addCourse(courseDto);
		
		courseDto = new CourseDto("React", Mode.ONLINE, Category.FE.getCategory(), "3 months", CourseLevel.INTERMEDIATE,
				"Shri");
		courseService.addCourse(courseDto);
		
		courseDto = new CourseDto("Microservices", Mode.ONLINE, Category.BE.getCategory(), "1 months",
				CourseLevel.ADVANCED, "Shri");
		courseService.addCourse(courseDto);
		System.out.println(courseService.getById(10));
		System.out.println();
		courseService.getAll().forEach(System.out::println);
//
		// get course by Id
		CourseDto courseDto1 = courseService.getById(10);
		CourseDto courseDto2 = courseService.getById(11);
		List<CourseDto> courses = Arrays.asList(courseDto1, courseDto2);
		System.out.println(courses);
//		System.out.println();
//		StudentDto studentDto = new StudentDto(null, "Rakesh", "CSE", "Bengaluru", courses);
//		studentService.addStudent(studentDto);
//
//		StudentDto nstudent = studentService.getById(1);
//		System.out.println(nstudent);
	}

}
