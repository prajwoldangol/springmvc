package com.course.repository;

import java.util.List;

import com.course.entity.CoursesEntity;

public interface CoursesDao {
	
	public String saveCourse(CoursesEntity coursesEntity);
	public String updateCourse(CoursesEntity coursesEntity);
	public List<CoursesEntity> getAllCourses();
	public CoursesEntity getCourseById( int courseId );
	public void deleteCourse( int courseId) ;
	
}
