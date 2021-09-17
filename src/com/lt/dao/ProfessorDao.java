package com.lt.dao;

import java.util.HashMap;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.bean.Student;

public interface ProfessorDao {
	/*
	 * This method will return the Student Data login details
	 */
	public List<Student> getStudentData();
	/*
	 * This method will return the Admin login details
	 */
	//public List<Course> getCourseData();
	/*
	 * This method will return the Admin login details
	 */
	public HashMap<Integer, String> getLoginDetails();
	/*
	 * This method will return the Admin login details
	 */
	public List<Grade> getGradeData();
	
	public boolean addGrade(Grade grade);
} 