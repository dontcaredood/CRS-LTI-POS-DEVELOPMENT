package com.lt.client;

import java.sql.SQLException;
import java.util.*;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.*;
import com.lt.business.ProfessorInterface;
import com.lt.business.ProfessorInterfaceImpl;
import com.lt.exceptions.GradeNotAddedException;

public class CRSProfessor {
	private static Logger logger = Logger.getLogger(CRSProfessor.class);
	ProfessorInterfaceImpl professorInterface= new ProfessorInterfaceImpl();
	
	
	public void createMenu(String profId)
	{
		Scanner sc=new Scanner(System.in);
		int input;
		while(CRSApplication.isValidUser)
		{
			System.out.println("-----------------------------");
			System.out.println("----------Professor Menu---------");
			System.out.println("_____________________________");
			System.out.println("1. View Courses");
			System.out.println("2. View Enrolled Students");
			System.out.println("3. Add grade");
			System.out.println("4. Logout");
			System.out.println("_____________________________");
			
			//input user
			input=sc.nextInt();
			switch(input)
			{
				case 1:
					//view all the courses taught by the professor
					getCourses(profId);
					break;
				case 2:
					//view all the enrolled students for the course
					viewEnrolledStudents(profId);
					break;
					
				case 3:
					//add grade for a student
					addGrade(profId);
					break;
				case 4:
					//logout from the system
					CRSApplication.isValidUser=false;
					return;
				default:
					logger.warn("***** Wrong Choice *****");
			}
		}
		
		
	}
	
	/**
	 * Method to view enrolled Students in courses
	 * @param profId
	 */
	public void viewEnrolledStudents(String profId)
	{
		List<Course> coursesEnrolled=professorInterface.getCourses(profId);
		System.out.println(String.format("%20s %20s %20s","COURSE CODE","COURSE CODE","Students  enrolled" ));
		try
		{
			List<RegisteredCourses> enrolledStudents=new ArrayList<RegisteredCourses>();
			enrolledStudents=professorInterface.viewEnrolledStudents(profId);
			for(RegisteredCourses obj: enrolledStudents)
			{
				System.out.println(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			
		}
		catch(Exception ex)
		{
			logger.error(ex.getMessage()+"Something went wrong, please try again later!");
		}
	}

	/**
	 * Method to get list of all Courses Professor has to teach
	 * @param profId
	 */
	public void getCourses(String profId)
	{
		try
		{
			List<Course> coursesEnrolled=professorInterface.getCourses(profId);
			System.out.println(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Course Description" ));
			for(Course obj: coursesEnrolled)
			{
				System.out.println(String.format("%20s %20s %20s",obj.getCourseId(), obj.getCourseName(),obj.getCourseDescription()));
			}		
		}
		catch(Exception ex)
		{
			logger.error("Something went wrong!"+ex.getMessage());
		}
	}
	
	/**
	 * Method to help Professor grade a student
	 * @param profId
	 */
	public void addGrade(String profId)
	{	
		Scanner sc=new Scanner(System.in);
		
		int studentId;
		String courseCode,grade;
		try
		{
			List<RegisteredCourses> enrolledStudents=new ArrayList<RegisteredCourses>();
			enrolledStudents=professorInterface.viewEnrolledStudents(profId);
			System.out.println(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student ID" ));
			for(RegisteredCourses obj: enrolledStudents)
			{
				System.out.println(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			List<Course> coursesEnrolled=new ArrayList<Course>();
			coursesEnrolled	=professorInterface.getCourses(profId);
			System.out.println("----------------Add Grade--------------");
			System.out.println("Enter student id");
			studentId=sc.nextInt();
			System.out.println("Enter course code");
			courseCode=sc.next();
			System.out.println("Enter grade");
			grade=sc.next();
			professorInterface.addGrade(studentId, courseCode, grade);
			System.out.println("Grade added successfully for "+studentId);
			
		}
		catch(GradeNotAddedException ex)
		{
			logger.error("Grade cannot be added for"+ex.getStudentId());
			
		}
		
	
	}

}
