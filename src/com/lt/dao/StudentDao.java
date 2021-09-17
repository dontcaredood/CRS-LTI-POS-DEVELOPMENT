package com.lt.dao;

import java.util.*;

import com.lt.bean.*;

public interface StudentDao {
	
	public boolean signup(Student student);
	public HashMap<Integer, String> getLoginDetails();
	public List<Grade> viewGrade();
	public List<Course> viewRegisteredCourses();
	public boolean addCourse(Course course);
	public boolean dropCourse(String courseName);
}
