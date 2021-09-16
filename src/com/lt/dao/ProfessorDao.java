package com.lt.dao;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.bean.Student;

public interface ProfessorDao {

	public List<Student> getStudentData();
	public List<Course> getCourseData();
	public void getLoginDetails(int username,String password);
	public List<Grade> getGradeData();
	public void addGrade(Grade grade);
}