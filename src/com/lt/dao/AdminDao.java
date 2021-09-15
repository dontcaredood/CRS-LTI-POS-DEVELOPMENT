package com.lt.dao;

import java.util.*;

import com.lt.bean.*;

public interface AdminDao {

	/*
	 * This method will return the Admin login details
	 */
	
	public HashMap<Integer, String> getLoginDetails();
	
	public List<Student> getStudentDetails();
	
	public boolean addProfessorData(Professor professsor);
	
	public boolean addCourses(Course course);
	
	public boolean removeCourses(Course course);
	
	public List<GradeCard> getGradeCardDetails();
	
}
