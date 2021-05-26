package com.course.dto;

public class CoursesDto {
	
	int courseId;
	String courseTitle;
	String courseDetails;
	int coursePrice ;
	int enrolledStudents;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseDetails() {
		return courseDetails;
	}
	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}
	public int getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}
	public int getEnrolledStudents() {
		return enrolledStudents;
	}
	public void setEnrolledStudents(int enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	@Override
	public String toString() {
		return "CoursesDto [courseId=" + courseId + ", courseTitle=" + courseTitle + ", courseDetails=" + courseDetails
				+ ", coursePrice=" + coursePrice + ", enrolledStudents=" + enrolledStudents + "]";
	}
	
	
}
