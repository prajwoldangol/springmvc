package com.course.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.course.dto.CoursesDto;
import com.course.entity.CoursesEntity;
import com.course.repository.CoursesDao;

@Service
@Transactional
public class CoursesServiceImpl implements CoursesService {
	
	@Autowired
	@Qualifier("CoursesRepo")
	CoursesDao coursesDao;
	
	@Override
	public String saveCourse(CoursesDto CoursesDto) {
		CoursesEntity courseEntity = new CoursesEntity();
		BeanUtils.copyProperties(CoursesDto, courseEntity);
		return coursesDao.saveCourse(courseEntity);
	}

	@Override
	public String updateCourse(CoursesDto CoursesDto) {
		CoursesEntity courseEntity = new CoursesEntity();
		BeanUtils.copyProperties(CoursesDto, courseEntity);
		return coursesDao.updateCourse(courseEntity);
	}

	@Override
	public List<CoursesDto> getAllCourses() {
		List<CoursesDto> coursesDto = new ArrayList<CoursesDto>();
		List<CoursesEntity> coursesEntity = coursesDao.getAllCourses();
		
		for( CoursesEntity c:coursesEntity) {
			CoursesDto cDto = new CoursesDto();
			BeanUtils.copyProperties(c, cDto);
			coursesDto.add(cDto);
		}
		return coursesDto;
	}

	@Override
	public CoursesDto getCourseById(int courseId) {
		CoursesEntity coursesEntity = coursesDao.getCourseById(courseId);
		CoursesDto coursesDto = new CoursesDto();
		BeanUtils.copyProperties(coursesEntity, coursesDto);
		return coursesDto;
	}

	@Override
	public void deleteCourse(int courseId) {
		coursesDao.deleteCourse(courseId);
		
	}

}
