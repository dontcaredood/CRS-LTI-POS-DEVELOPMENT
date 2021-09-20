package com.lt.client;

import java.util.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.*;
import com.lt.constants.*;
import com.lt.business.AdminInterfaceImpl;
import com.lt.exceptions.*;

public class CRSAdmin {
	private static Logger logger = Logger.getLogger(CRSAdmin.class);
	AdminInterfaceImpl adminInterfaceImpl = new AdminInterfaceImpl();
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * Method to Create Admin Menu
	 */
	public void createMenu(){
		
		while(CRSApplication.isValidUser) {
			System.out.println("_____________________________");
			System.out.println("----------CRS Admin---------");
			System.out.println("_____________________________");
			System.out.println("1. View Courses");
			System.out.println("2. Add Courses");
			System.out.println("3. Delete Course");
			System.out.println("4. Approve Students");
			System.out.println("5. Add Professor");
			System.out.println("6. Assign Courses To Professor");
			System.out.println("7. Logout");
			System.out.println("_____________________________");
			
			int choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				viewCourses();
				break;
				
			case 2:
				addCourse();
				break;
				
			case 3:
				deleteCourse();
				break;
				
			case 4:
				approveStudent();
				break;
			
			case 5:
				addProfessor();
				break;
			
			case 6:
				assignCourseToProfessor();
				break;
			
			case 7:
				CRSApplication.isValidUser = false;
				return;

			default:
				logger.warn("***** Wrong Choice *****");
			}
		}
	}
	
	/**
	 * Method to assign Course to a Professor
	 */
	private void assignCourseToProfessor() {
		List<Professor> professorList= adminInterfaceImpl.showProfessors();
		System.out.println("*************************** Professor *************************** ");
		System.out.println(String.format("%20s | %20s | %20s ", "ProfessorId", "Name", "Designation"));
		for(Professor professor : professorList) {
			System.out.println(String.format("%20s | %20s | %20s ", professor.getUserId(), professor.getName(), professor.getDesignation()));
		}
		
		//addign
	}
		
		
	/**
	 * Method to add Professor to DB
	 */
	private void addProfessor() {
		
		Professor professor = new Professor();
		
		System.out.println("Enter Professor Name:");
		String professorName = scanner.next();
		professor.setName(professorName);
		
		System.out.println("Enter Department:");
		String department = scanner.next();
		professor.setDepartment(department);
		
		System.out.println("Enter Designation:");
		String designation = scanner.next();
		professor.setDesignation(designation);
		
		System.out.println("Enter User Id:");
		String userId = scanner.next();
		professor.setUserId(userId);
		
		System.out.println("Enter Password:");
		String password = scanner.next();
		professor.setPassword(password);
		
		System.out.println("Enter Gender: \t 1: Male \t 2.Female \t 3.Other ");
		int gender = scanner.nextInt();
		professor.setGender(Gender.getName(gender));
		
		System.out.println("Enter Address:");
		String address = scanner.next();
		professor.setAddress(address);
		
		professor.setRole(Role.stringToName("Professor"));
		boolean isProfessorAdded = false;
		try {
			isProfessorAdded = adminInterfaceImpl.addProfessor(professor);
			if(!isProfessorAdded) {  throw  new ProfessorNotAddedException(professorName); }
		} catch (ProfessorNotAddedException e) {
			logger.error(e.getMessage());
		}
		
	}
	
	/**
	 * Method to approve a Student using Student's ID
	 */
	private void approveStudent() {
		
		List<Student> studentList = viewPendingAdmissions();
		if(studentList.size() == 0) {
			return;
		}
		
		System.out.println("Enter Student's ID:");
		int studentUserIdApproval = scanner.nextInt();
		
		
		  try { 
			  adminInterfaceImpl.approveStudent(studentUserIdApproval); //send
		  //notification from system
		  //notificationInterface.sendNotification(NotificationType.
		  //REGISTRATION_APPROVAL, studentUserIdApproval, null,0);
		  
		  } catch (Exception e) {
		  logger.error(e.getMessage()); }
		 
	}
	/**
	 * Method to view Students who are yet to be approved
	 * @return List of Students whose admissions are pending
	 */
	private List<Student> viewPendingAdmissions() {
		
		List<Student> pendingStudentsList= adminInterfaceImpl.showPendingForApprovalStudent();
		if(pendingStudentsList.size() == 0) {
			return pendingStudentsList;
		}
		System.out.println(String.format("%20s | %20s | %20s | %20s", "UserId", "StudentId", "Name", "Gender"));
		for(Student student : pendingStudentsList) {
			System.out.println(String.format("%20s | %20d | %20s | %20s", student.getUserId(), student.getStudentId(), student.getName(), student.getGender().toString()));
		}
		return pendingStudentsList;
	}

	/**
	 * Method to delete Course from catalogue
	 * @throws CourseNotFoundException 
	 */
	private void deleteCourse() {
		List<Course> courseList = viewCourses();
		System.out.println("Enter Course Code:");
		String courseCode = scanner.next();
		boolean isDeleted = false;
		try {
			
			isDeleted = adminInterfaceImpl.removeCourse(courseCode);
			if(isDeleted) {
				System.out.println("Course Code :"+ courseCode+ " deleted Sucessfully!");
			}else {
				throw new CourseNotDeletedException(courseCode);
				}
		} catch (CourseNotDeletedException e) {
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * Method to add Course to catalogue
	 */
	private void addCourse() {
		List<Course> courseList = viewCourses();
		boolean isAdded = false;
		scanner.nextLine();
		System.out.println("Enter Course Code:");
		String courseCode = scanner.nextLine();
		System.out.println("Enter Course Name:");
		String courseName = scanner.next();
		System.out.println("Enter Course Description:");
		String courseDesc = scanner.next();
		System.out.println("Enter Professor ID:");
		String professorId = scanner.next();
		Course course = new Course(courseCode, courseName, courseDesc, professorId);
		try {
			isAdded = adminInterfaceImpl.addCourses(course);
			if(isAdded) {
				System.out.println("Course Code :"+ courseCode+ " added Sucessfully!");
			}else {
				throw new CourseFoundException(courseCode);
				}
		} catch (CourseFoundException e) {
			logger.error(e.getMessage());
		}						

	}
	/**
	 * Method to display courses in catalogue
	 * @return List of courses in catalogue
	 */
	private List<Course> viewCourses() {
		List<Course> courseList = adminInterfaceImpl.showCourses();
		if(courseList.size() == 0) {
			System.out.println("No course available in the catalogue!");
			return courseList;
		}
		System.out.println(String.format("%20s | %20s | %20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
		for(Course course : courseList) {
			System.out.println(String.format("%20s | %20s | %20s", course.getCourseId(), course.getCourseName(), course.getProfessorId()));
		}
		return courseList;
	}
}
