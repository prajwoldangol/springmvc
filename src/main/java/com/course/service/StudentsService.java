package com.course.service;

import java.util.List;

import com.course.dto.CoursesDto;
import com.course.dto.StudentsDto;

public interface StudentsService {
	
	public String saveStudents(StudentsDto studentsDto);
	public String updateStudents(StudentsDto studentsDto);
	public StudentsDto authenticateStudent( String studentEmail, String studentPassword);
	public StudentsDto getStudentById(int studentId);
	public String updateEnrolledCourses( String enrolledCourses, int studentId);
	public List<CoursesDto> getEnrolledCourses( List<Integer> enrolledCourses);
}
