package com.lt.dao;

import com.lt.bean.Course;

public interface StudentDao {

	public void addCourse(Course course);
	
	public void dropCourse(String courseName);
	
}
