package com.lt.client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.business.*;
import com.lt.business.ProfessorInterfaceImpl;
import com.lt.business.RegisteredCoursesInterfaceImpl;
import com.lt.constants.ModeOfPayment;
import com.lt.constants.NotificationType;
import com.lt.exceptions.CourseLimitExceedException;
import com.lt.exceptions.CourseNotFoundException;
import com.lt.exceptions.SeatNotAvailableException;

public class CRSStudent {

	private static Logger logger = Logger.getLogger(CRSStudent.class);
	Scanner sc = new Scanner(System.in);
	ProfessorInterfaceImpl professorInterface =  ProfessorInterfaceImpl.getInstance();
	RegisteredCoursesInterfaceImpl registrationInterface =  RegisteredCoursesInterfaceImpl.getInstance();
	NotificationInterfaceImpl notificationInterfaceImpl = NotificationInterfaceImpl.getInstance();
	private boolean is_registered;
	
	/**
	 * Method to generate Student Menu for course registration, addition, removal and fee payment 
	 * @param studentId student id 
	 */
	public void create_menu(int studentId)
	{

		is_registered = getRegistrationStatus(studentId);
		while (CRSApplication.isValidUser) 
		{
			System.out.println("_____________________________");
			System.out.println("**********Student Menu*********");
			System.out.println("_____________________________");
			System.out.println("1. Course Registration");
			System.out.println("2. Add Course");
			System.out.println("3. Drop Course");
			System.out.println("4. View Course");
			System.out.println("5. View Registered Courses");
			System.out.println("6. View grade card");
			System.out.println("7. Make Payment");
			System.out.println("8. Logout");
			System.out.println("_____________________________");

			int choice = sc.nextInt();

			switch (choice) {
				case 1: 
						registerCourses(studentId);
						break;
						
				case 2: 
						addCourse(studentId);
						break;

				case 3:
						
						dropCourse(studentId);
						break;

				case 4:
						viewCourse(studentId);
						break;

				case 5:
						viewRegisteredCourse(studentId);
						break;

				case 6:
						viewGradeCard(studentId);
						break;
						
				case 7:
						make_payment(studentId);
						break;
						
				case 8: 
						CRSApplication.isValidUser = false;
						return;
						
				default:
						logger.warn("***** Wrong Choice *****");
			}
		}
	}
	

	/**
	 * Select course for registration
	 * @param studentId
	 */
	private void registerCourses(int studentId)
	{
			if(is_registered)
			{
				System.out.println(" Registration is already completed");
				return;
			}
			
			int count = 0;
			while(count < 4)
			{
				try
				{
					List<Course> courseList=viewCourse(studentId);
					
					if(courseList==null)
						return;
					
					System.out.println("Enter Course Code : " + (count+1));
					String courseCode = sc.next();
					
					if(registrationInterface.addCourse(courseCode,studentId,courseList))
					{
						System.out.println("Course " + courseCode + " registered sucessfully.");
						count++;
					}
					else
					{
						System.out.println(" You have already registered for Course : " + courseCode);
					}
				}	
				catch( SQLException | CourseNotFoundException | CourseLimitExceedException | SeatNotAvailableException e)
				{
					System.out.println(e.getMessage());
				}
			}
			
		    System.out.println("Registration Successful");	
		    is_registered = true;
		    
		    try 
		    {
				registrationInterface.setRegistrationStatus(studentId);
			} 
		    catch (SQLException e) 
		    {
				System.out.println(e.getMessage());
			}
		
	}
	
	/**
	 * Add course for registration
	 * @param studentId
	 */
	private void addCourse(int studentId)	
	{
		if(is_registered)
		{
			List<Course> availableCourseList=viewCourse(studentId);
			
			if(availableCourseList==null)
				return;
	
			try
			{
				System.out.println("Enter Course Code : " );
				String courseCode = sc.next();
				if(registrationInterface.addCourse(courseCode, studentId,availableCourseList))
				{
					System.out.println(" You have successfully registered for Course : " + courseCode);
				}
				else
				{
					System.out.println(" You have already registered for Course : " + courseCode);
				}
			}
			catch( SQLException | CourseNotFoundException | CourseLimitExceedException | SeatNotAvailableException e)
			{
				System.out.println(e.getMessage());
			}
		}
		else 
		{
			System.out.println("Please complete registration");
		}

		
	}
	
	/**
	 * Method to check if student is already registered
	 * @param studentId
	 * @return Registration Status
	 */
	private boolean getRegistrationStatus(int studentId)
	{
		try 
		{
			return registrationInterface.getRegistrationStatus(studentId);
		} 
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	/**
	 * Drop Course
	 * @param studentId
	 */
	private void dropCourse(int studentId)
	{
		if(is_registered)
		{
			List<Course> registeredCourseList=viewRegisteredCourse(studentId);
			
			if(registeredCourseList==null)
				return;
			
			System.out.println("Enter the Course Code : ");
			String courseCode = sc.next();
			
			try
			{
				registrationInterface.dropCourse(courseCode, studentId,registeredCourseList);
				System.out.println("You have successfully dropped Course : " + courseCode);
				
			}
			catch(CourseNotFoundException e)
			{
				System.out.println("You have not registered for course : " + e.getCourseCode());
			} 
			catch (SQLException e) 
			{

                System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("Please complete registration");
		}

	}
	
	/**
	 * View all available Courses 
	 * @param studentId
	 * @return List of available Courses 
	 */
	private List<Course> viewCourse(int studentId)
	{
		List<Course> course_available=null;
		try 
		{
			course_available = registrationInterface.viewCourses(studentId);
		}
		catch (SQLException e) 
		{

            System.out.println(e.getMessage());
		}
	
	
		if(course_available.isEmpty())
		{
			System.out.println("NO COURSE AVAILABLE");
			return null;
		}
		

		System.out.println(String.format("%-20s %-20s %-20s ","COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
		for(Course obj : course_available)
		{
			System.out.println(String.format("%-20s %-20s %-20s ",obj.getCourseId(), obj.getCourseName(),obj.getProfessorId()));
		}
		
		return course_available;

	}
	
	/**
	 * View Registered Courses
	 * @param studentId
	 * @return List of Registered Courses
	 */
	private List<Course> viewRegisteredCourse(int studentId)
	{
		List<Course> course_registered=null;
		try 
		{
			course_registered = registrationInterface.viewRegisteredCourses(studentId);
		} 
		catch (SQLException e) 
		{

            System.out.println(e.getMessage());
		}
		
		if(course_registered.isEmpty())
		{
			System.out.println("You haven't registered for any course");
			return null;
		}
		
		System.out.println(String.format("%-20s %-20s %-20s","COURSE CODE", "COURSE NAME", "INSTRUCTOR"));
		
		for(Course obj : course_registered)
		{
			 
			
			System.out.println(String.format("%-20s %-20s %-20s ",obj.getCourseId(), obj.getCourseName(),professorInterface.getProfessorById(obj.getProfessorId())));
		}
		
		return course_registered;
	}
	
	/**
	 * View grade card for particular student  
	 * @param studentId
	 */
	private void viewGradeCard(int studentId)
	{
		
		
		List<Grade> grade_card=null;
		try 
		{
			grade_card = registrationInterface.viewGradeCard(studentId);
		} 
		catch (SQLException e) 
		{

            System.out.println(e.getMessage());
		}
		
		System.out.println(String.format("%-20s %-20s %-20s","COURSE CODE", "COURSE NAME", "GRADE"));
		
		if(grade_card.isEmpty())
		{
			System.out.println("You haven't registered for any course");
			return;
		}
		
		for(Grade obj : grade_card)
		{
			System.out.println(String.format("%-20s %-20s %-20s",obj.getCourseCode(), obj.getCourseName(),obj.getGrade()));
		}
	}
	
	/**
	 * Make Payment for selected courses. Student is provided with an option to pay the fees and select the mode of payment.
	 * @param studentId
	 */
	private void make_payment(int studentId)
	{
		
		double fee =0.0;
		try
		{
			fee=registrationInterface.calculateFee(studentId);
		} 
		catch (SQLException e) 
		{

            System.out.println(e.getMessage());
		}

		if(fee == 0.0)
		{
			System.out.println("You have not  registered for any courses yet");
		}
		else
		{
			
			System.out.println("Your total fee  = " + fee);
			System.out.println("Want to continue Fee Payment(y/n)");
			String ch = sc.next();
			if(ch.equals("y"))
			{
				System.out.println("Select Payment Method:\n1.Online\n2.Offline");
				int method = sc.nextInt();
				String paymentMethod = "";
				if(method != 1) {
					paymentMethod ="OFFLINE";
					System.out.println("Select Mode of Payment:");
					int index = 1;
					for(ModeOfPayment mode : ModeOfPayment.values())
					{
						if(mode.name()=="CASH" || mode.name()=="CHEQUE") {
							System.out.println(index + " " + mode);
							index = index + 1;
						}
					}
					
					ModeOfPayment mode = ModeOfPayment.getModeofPayment(sc.nextInt()+3);
					if(mode == null)
						System.out.println("Invalid Input");
					else
					{
						
						  try { 
							  notificationInterfaceImpl.sendNotification(NotificationType.PAYMENT, studentId, mode,paymentMethod, fee); } catch (Exception e) {
						  
						  System.out.println(e.getMessage()); }
						 
					}
					
				}else{
					paymentMethod ="ONLINE";
					System.out.println("Select Mode of Payment:");
					
					int index = 1;
					for(ModeOfPayment mode : ModeOfPayment.values())
					{
						if(mode.name() == "CREDIT_CARD"|| mode.name()=="NET_BANKING" || mode.name()=="DEBIT_CARD") {
							System.out.println(index + " " + mode);
							index = index + 1;
						}
					}
					
					ModeOfPayment mode = ModeOfPayment.getModeofPayment(sc.nextInt());
					
					if(mode == null)
						System.out.println("Invalid Input");
					else
					{
						
						  try { 
							  notificationInterfaceImpl.sendNotification(NotificationType.PAYMENT, studentId, mode,paymentMethod, fee); } catch (Exception e) {
						  
						  System.out.println(e.getMessage()); }
						 
					}
				}
			
					
			}
			
		}
		
	}
	
	

}
