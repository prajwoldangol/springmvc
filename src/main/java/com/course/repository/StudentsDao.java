package com.course.repository;

import java.util.List;

import com.course.entity.CoursesEntity;
import com.course.entity.StudentsEntity;

public interface StudentsDao {
	
	public String saveStudents(StudentsEntity students);
	public String upateStudents(StudentsEntity students) ;
	public StudentsEntity authenticateStudents( String studentEmail, String studentPassword);
	public StudentsEntity getStudentById(int studentId);
	public String updateEnrolledCourses( String enrolledCourses, int studentId);
	public List<CoursesEntity> getEnrolledCourses( List<Integer> enrolledCourses);
}
