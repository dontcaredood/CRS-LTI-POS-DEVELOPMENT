package com.lt.dao;

import java.util.*;

import com.lt.bean.*;
import com.lt.exceptions.*;

public interface AdminDao {
	
	/**
	 * Delete Course using SQL commands
	 * @param courseCode
	 * @return 
	 * @throws CourseNotFoundException
	 * @throws CourseNotDeletedException 
	 */
	public boolean deleteCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException;

	/**
	 * Add Course using SQL commands
	 * @param course
	 * @return 
	 * @throws CourseFoundException
	 */
	public boolean addCourse(Course course) throws CourseFoundException;
	/**
	 * Fetch Students yet to approved using SQL commands
	 * @return List of Students yet to approved
	 */
	public List<Student> viewPendingAdmissions();
	
	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 * @throws StudentNotFoundException
	 */
	public void approveStudent(int studentId) throws StudentNotFoundForApprovalException;
	
	/**
	 * Add professor using SQL commands
	 * @param professor
	 * @return 
	 * @throws ProfessorNotAddedException
	 * @throws UserIdAlreadyInUseException 
	 * @throws UserNotAddedException 
	 */
	public boolean addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;
	
	/**
	 * Method to add user using SQL commands
	 * @param user
	 * @throws UserNotAddedException
	 * @throws UserIdAlreadyInUseException 
	 */
	public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;
	
	/**
	 * Assign courses to Professor using SQL commands
	 * @param courseCode
	 * @param professorId
	 * @throws CourseNotFoundException
	 * @throws UserNotFoundException 
	 */
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException, UserNotFoundException;
	
	/**
	 * View courses in the catalog
	 * @param Catalog ID
	 * @return List of courses in the catalog
	 */
	public List<Course> viewCourses();
	
	/**
	 * View professor in the institute
	 * @return List of the professors in the institute  
	 */
	public List<Professor> viewProfessors();
}
