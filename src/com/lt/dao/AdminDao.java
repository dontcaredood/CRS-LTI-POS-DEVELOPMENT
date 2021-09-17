package com.lt.dao;

import java.util.*;

import com.lt.bean.*;

public interface AdminDao {

	/*
	 * This method will return the Admin login details
	 */
	public HashMap<Integer, String> getLoginDetails();
	
	/*
	 * This method will return the Student details
	 */
	public List<Student> getStudentDetails();

	/*
	 * This method will add professor to database
	 * @param Professor
	 */
	public boolean addProfessorData(Professor professsor);

	/*
	 * This method will add Course to CRS_COURSE table 
	 * @param Course
	 */
	public boolean addCourses(Course course);

	/*
	 * This method will remove the course frp, CRS_COURSE table
	 */
	public boolean removeCourses(String courseId);

	/*
	 * This method will return the Grade details from the GradeCard table
	 */
	public List<GradeCard> getGradeCardDetails();
	
	/*
	 * This method will approve the student
	 */
	public boolean approveStudent(int studentId , String result);
	
	/*
	 * This method will show the courses from DB
	 */
	public ArrayList<Course> showCourses();
	
	/*
	 * This method will show the courses from DB
	 */
	public ArrayList<Professor> showProfessors();
}
