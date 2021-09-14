package com.lt.business;

import com.lt.bean.Course;

public interface AdminInterface {

	public void login();
	public void addProfessor();
	public String approveStudent();
	public void addCourses(Course course);
	public boolean removeCourse(int id);
	public void generateReport();

}
