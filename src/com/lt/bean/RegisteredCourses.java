package com.lt.bean;

public class RegisteredCourses {
	private String courseTitle;
	private Student student;
	private String selectedCourse; 
	
	public final String getCourseTitle() {
		return courseTitle;
	}
	public final void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public final Student getStudent() {
		return student;
	}
	public final void setStudent(Student student) {
		this.student = student;
	}
	public final String getSelectedCourse() {
		return selectedCourse;
	}
	public final void setSelectedCourse(String selectedCourse) {
		this.selectedCourse = selectedCourse;
	}
	
}
