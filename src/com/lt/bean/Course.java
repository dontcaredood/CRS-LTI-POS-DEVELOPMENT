package com.lt.bean;

public class Course {
	private String courseId;
	private String courseName;
	private String courseDescription;
	
	public final String getCourseName() {
		return courseName;
	}
	public final void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
}
