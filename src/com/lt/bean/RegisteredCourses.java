package com.lt.bean;

public class RegisteredCourses {
	private String courseTitle;
	private Student student;
	private String selectedCourse;
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getSelectedCourse() {
		return selectedCourse;
	}
	public void setSelectedCourse(String selectedCourse) {
		this.selectedCourse = selectedCourse;
	} 
	
	
}
