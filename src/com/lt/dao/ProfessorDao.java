package com.lt.dao;

import java.util.HashMap;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.bean.Student;

public interface ProfessorDao {
	/*
	 * getStudentData is to fetch student details from the database table
	*/
	public List<Student> getStudentData();
	/*
	 * getCourseData is to fetch student details from the database table
	*/
	public List<Course> getCourseData();
	/*
	  * getLoginDetails is to fetch student details from the database table
	  * @param username
	  * @param password
	  * 
	*/
	public void getLoginDetails(String username,String password);
	/* 
	 * getGradeData is to fetch student details from the database table
	*/
	public List<Grade> getGradeData();
}