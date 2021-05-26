package com.course.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.course.entity.CoursesEntity;
import com.course.entity.StudentsEntity;

@Repository("StudentsRepo")
public class StudentsRepository implements StudentsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public String saveStudents(StudentsEntity students) {
		getSession().save(students);
		return "Insert Sucessful " ;
	}

	@Override
	public String upateStudents(StudentsEntity students) {
		getSession().merge(students);
		return "Update Successful";
	}

	@Override
	public StudentsEntity authenticateStudents(String studentEmail, String studentPassword) {
		TypedQuery<StudentsEntity> query = getSession().createQuery(" from StudentsEntity s where s.studentEmail=:pstudentEmail and s.studentPassword=:pstudentPassword");
		query.setParameter("pstudentEmail", studentEmail);
		query.setParameter("pstudentPassword", studentPassword);
		StudentsEntity student = null;
		try {
		student = query.getSingleResult();
		}catch(Exception e) {
			return null ;
		}
		
		return student ;
	}

	@Override
	public StudentsEntity getStudentById(int studentId) {
		TypedQuery<StudentsEntity> query = getSession().createQuery("from StudentsEntity s where s.studentId=:pstudentId");
		query.setParameter("pstudentId",studentId);
		StudentsEntity student = query.getSingleResult();
		return student;
	}

	@Override
	public String updateEnrolledCourses(String enrolledCourses, int studentId) {
		/*
		 * TypedQuery<StudentsEntity> query = getSession().
		 * createQuery(" update StudentsEntity s set s.enrolledCourses=:penrolledCourses where s.studentId=:pstudentId"
		 * ); query.setParameter("penrolledCourses", enrolledCourses);
		 * query.setParameter("pstudentId", studentId); return "Boom";
		 */
		StudentsEntity studentsEntity = getStudentById(studentId);
		
		studentsEntity.setEnrolledCourses(enrolledCourses);
		
		return upateStudents(studentsEntity);
		//return null;
	}

	@Override
	public List<CoursesEntity> getEnrolledCourses(List<Integer> enrolledCourses) {
//		@SuppressWarnings("unchecked")
		TypedQuery<CoursesEntity> query = getSession().createQuery("from CoursesEntity c where c.courseId  IN (:pcourseId)");
		
		((Query) query).setParameterList("pcourseId", enrolledCourses);
		
		List<CoursesEntity> c = (List<CoursesEntity>) query.getResultList();
		System.out.println("from repo" +c);
		return  c;
	}

}
