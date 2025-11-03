package com.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentapp.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Integer>{

}
