package com.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentapp.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer>{

}
