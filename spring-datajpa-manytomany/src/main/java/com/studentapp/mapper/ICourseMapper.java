package com.studentapp.mapper;

import java.util.Collections;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.studentapp.model.Course;
import com.studentapp.model.CourseDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICourseMapper {
	
	Course toEntity(CourseDto dto);

	@Mapping(target = "students", ignore = true)
	CourseDto toDto(Course course);
	
	@AfterMapping
    default CourseDto ensureNonNullStudents(Course course, @MappingTarget CourseDto dto) {
        if (dto.students() == null) {
            return new CourseDto(
                    dto.courseId(),
                    dto.courseName(),
                    dto.mode(),
                    dto.category(),
                    dto.duration(),
                    dto.courseLevel(),
                    dto.instructor(),
                    Collections.emptyList()
            );
        }
        return dto;
    }
	
}
