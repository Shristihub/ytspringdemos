package com.studentapp.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.studentapp.mapper.ICourseMapper;
import com.studentapp.model.Course;
import com.studentapp.model.CourseDto;
import com.studentapp.repository.ICourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {
	private  final ICourseMapper mapper;
	private final ICourseRepository courseRepository;


	@Override
	public void addCourse(CourseDto courseDto) {
		Course course= mapper.toEntity(courseDto);
		System.out.println(course);
		courseRepository.save(course);

	}

	@Override
	public void updateCourse(CourseDto courseDto) {
		Course course= mapper.toEntity(courseDto);
		courseRepository.save(course);


	}

	@Override
	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);

	}

	@Override
	public CourseDto getById(int courseId) {
		Course course = courseRepository.findById(courseId)
				.orElseThrow(()-> new RuntimeException("invalid Id"));
		System.out.println(course);
			return mapper.toDto(course);
	}

	@Override
	public List<CourseDto> getAll() {
		List<Course> courses =  courseRepository.findAll();
		System.out.println("...........................");
		System.out.println(courses);
		return courses
				.stream()
				.map(mapper::toDto)
//				.map(dto -> dto.students() == null
//                ? new CourseDto(dto.courseId(), dto.courseName(), dto.mode(),
//                    dto.category(), dto.duration(), dto.courseLevel(),
//                    dto.instructor(), Collections.emptyList())
//                : dto)
				.toList();
	}

	

}
