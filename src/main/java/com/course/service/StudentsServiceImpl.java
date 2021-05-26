package com.course.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.course.dto.CoursesDto;
import com.course.dto.StudentsDto;
import com.course.entity.CoursesEntity;
import com.course.entity.StudentsEntity;
import com.course.repository.StudentsDao;

@Service
@Transactional
public class StudentsServiceImpl implements StudentsService{
	
	@Autowired
	@Qualifier("StudentsRepo")
	StudentsDao studentsDao ;
	
	@Override
	public String saveStudents(StudentsDto studentsDto) {
		StudentsEntity students 	= new StudentsEntity();
		BeanUtils.copyProperties(studentsDto, students);
//		if( Validations.isValidNum(students.getStudentPhone())) 
			
		return studentsDao.saveStudents(students);
		
	}

	@Override
	public String updateStudents(StudentsDto studentsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentsDto authenticateStudent(String studentEmail, String studentPassword) {
		StudentsEntity students 	= studentsDao.authenticateStudents(studentEmail, studentPassword);
		StudentsDto studentsDto = null ;
		
		if( students != null) {
			
			studentsDto = new StudentsDto();
			BeanUtils.copyProperties(students, studentsDto);
		}
		return studentsDto;
	}

	@Override
	public StudentsDto getStudentById(int studentId) {
		StudentsDto studentDto = new StudentsDto();
		StudentsEntity studentsEntity = studentsDao.getStudentById(studentId);
//		if( studentsEntity != null ) {
			BeanUtils.copyProperties(studentsEntity, studentDto);
//		}
		return studentDto;
	}

	@Override
	public String updateEnrolledCourses(String enrolledCourses, int studentId) {
		
		return studentsDao.updateEnrolledCourses(enrolledCourses, studentId);
	}

	@Override
	public List<CoursesDto> getEnrolledCourses(List<Integer> enrolledCourses) {
		List<CoursesDto> coursesDto = new ArrayList<CoursesDto>();
		List<CoursesEntity> coursesEntity =  studentsDao.getEnrolledCourses(enrolledCourses);
		for( CoursesEntity c:coursesEntity) {
			CoursesDto cDto = new CoursesDto();
			BeanUtils.copyProperties(c, cDto);
			coursesDto.add(cDto);
		}
	

		return  coursesDto;
	}

}
