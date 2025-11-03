package com.studentapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = "students")
public class Course {
	@Id
	@GeneratedValue(generator = "course_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "course_gen",sequenceName = "course_seq",initialValue = 10,allocationSize = 1)
	private Integer courseId;
	@Column(length=30)
	private String courseName;
	@Enumerated(EnumType.STRING)
	private Mode mode;
	@Column(length=30)
	private String category; // take values from enum web,frontend
	private String duration;
	@Enumerated(EnumType.STRING)
	private CourseLevel courseLevel;
	private String instructor;
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;
	public Course( String courseName, Mode mode, String category, String duration,
			CourseLevel courseLevel, String instructor) {
		super();
		this.courseName = courseName;
		this.mode = mode;
		this.category = category;
		this.duration = duration;
		this.courseLevel = courseLevel;
		this.instructor = instructor;
	}
	
	
	
	
	
	

}
