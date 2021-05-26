package com.course.service;

import java.util.List;

import com.course.dto.CoursesDto;

public interface CoursesService {
	
	public String saveCourse(CoursesDto CoursesDto);
	public String updateCourse(CoursesDto CoursesDto);
	public List<CoursesDto> getAllCourses();
	public CoursesDto getCourseById( int courseId );
	public void deleteCourse( int courseId) ;
}
