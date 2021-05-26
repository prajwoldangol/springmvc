package com.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class CoursesEntity {
	
	int courseId;
	String courseTitle;
	String courseDetails;
	int coursePrice ;
	int enrolledStudents;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	@Column
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	@Column
	public String getCourseDetails() {
		return courseDetails;
	}
	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}
	@Column
	public int getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}
	@Column
	public int getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(int enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	@Override
	public String toString() {
		return "CoursesEntity [courseId=" + courseId + ", courseTitle=" + courseTitle + ", courseDetails="
				+ courseDetails + ", coursePrice=" + coursePrice + ", enrolledStudents=" + enrolledStudents + "]";
	}
	
	
}
