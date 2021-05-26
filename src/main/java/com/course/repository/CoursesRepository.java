package com.course.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course.entity.CoursesEntity;

@Repository("CoursesRepo")
public class CoursesRepository implements CoursesDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String saveCourse(CoursesEntity coursesEntity) {
		getSession().save(coursesEntity);
		return "New Course Added" ;
	}

	@Override
	public String updateCourse(CoursesEntity coursesEntity) {
		getSession().merge(coursesEntity);
		return "Course Details Updated " ;
	}

	@Override
	public List<CoursesEntity> getAllCourses() {
		TypedQuery<CoursesEntity> query = getSession().createQuery( " from CoursesEntity") ; 
		List<CoursesEntity> courses = query.getResultList();
		return courses;
	}

	@Override
	public CoursesEntity getCourseById(int courseId) {
		TypedQuery<CoursesEntity> query = getSession().createQuery("from CoursesEntity c where c.courseId = :pcourseId");
		query.setParameter("pcourseId", courseId);
		CoursesEntity course = query.getSingleResult();
		return course;
	}

	@Override
	public void deleteCourse(int courseId) {
		
		CoursesEntity course = getCourseById(courseId);
		getSession().delete(course);
		
	}

}
