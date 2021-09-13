package com.lt.bean;

public class Course {
	private int courseId;
	private String courseName;
	private int courseCatalogId;
	
	public final int getCourseId() {
		return courseId;
	}
	public final void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public final String getCourseName() {
		return courseName;
	}
	public final void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public final int getCourseCatalogId() {
		return courseCatalogId;
	}
	public final void setCourseCatalogId(int courseCatalogId) {
		this.courseCatalogId = courseCatalogId;
	}
	
	
}
