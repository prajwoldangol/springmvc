package com.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class StudentsEntity {
	int studentId ;
	String studentName;
	String studentPhone;
	String studentEmail;
	String studentPassword;
	String enrolledCourses;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	@Column
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Column
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	@Column
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	@Column
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	@Column(columnDefinition = "TEXT")
	public String getEnrolledCourses() {
		return enrolledCourses;
	}
	public void setEnrolledCourses(String enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	@Override
	public String toString() {
		return "StudentsEntity [studentId=" + studentId + ", studentName=" + studentName + ", studentPhone="
				+ studentPhone + ", studentEmail=" + studentEmail + ", studentPassword=" + studentPassword
				+ ", enrolledCourses=" + enrolledCourses + "]";
	}
	
}
