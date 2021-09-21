package com.lt.client;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.Student;
import com.lt.business.AdminInterfaceImpl;
import com.lt.business.ProfessorInterfaceImpl;
import com.lt.business.StudentInterfaceImpl;
import com.lt.business.UserInterfaceImpl;
import com.lt.constants.Gender;
import com.lt.constants.Role;
import com.lt.dao.StudentDaoImpl;
import com.lt.exceptions.StudentNotRegisteredException;
import com.lt.exceptions.UserNotFoundException;

public class CRSApplication {
	static boolean isValidUser = false;	
	UserInterfaceImpl userInterfaceImpl =  UserInterfaceImpl.getInstance();
	private static Logger logger = Logger.getLogger(CRSApplication.class);
	StudentInterfaceImpl studentInterfaceImpl =  StudentInterfaceImpl.getInstance();

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		CRSApplication crsApplication = new CRSApplication();
		System.out.println("Course Registration System");
		System.out.println("---------------------------");
		System.out.println("1.Sign Up\n2.Login\n3.Update Password\n4.Exit");
		int choice = scan.nextInt();
		try {
			while(choice !=4) {
				switch(choice)
				{	
					case 1:
						crsApplication.studentRegister();
						break;
					case 2:
						crsApplication.userLogin();
						break;	
					case 3:
						crsApplication.updatePassword();
						break;
					case 4:
						System.out.println("Bye!");
						
						break;
					default:
						System.out.println("Invalid Input");
				}
				main(null);
			}
		} catch (Exception e) {
			logger.error("CRSAPPLICATION : "+e);
		}
		
		
		
		
		
	}
	 
	public void updatePassword()
	{
		/*
		 * Scanner sc=new Scanner(System.in); String userId,newPassword; try {
		 * System.out.println("------------------Update Password--------------------");
		 * System.out.println("Email"); userId=sc.next(); System.out.println("New Password:");
		 * newPassword=sc.next(); boolean isUpdated=userInterface.updatePassword(userId,
		 * newPassword); if(isUpdated) System.out.println("Password updated successfully!");
		 * 
		 * else logger.error("Something went wrong, please try again!"); }
		 * catch(Exception ex) { logger.error("Error Occured "+ex.getMessage()); }
		 */}
	public void studentRegister()
	{	
		Scanner sc=new Scanner(System.in);

		String userId,name,password,address,country,branchName;
		Gender gender;
		int genderV, batch;
		try
		{
			//input all the student details
			System.out.println("---------------Student Registration-------------");
			System.out.println("Name:");
			name=sc.nextLine();
			System.out.println("Email:");
			userId=sc.next();
			System.out.println("Password:");
			password=sc.next();
			System.out.println("Gender: \t 1: Male \t 2.Female\t 3.Other");
			genderV=sc.nextInt();
			System.out.println("Branch:");
			branchName=sc.next();
			sc.nextLine();
			System.out.println("Address:");
			address=sc.nextLine();
			gender=Gender.getName(genderV);
			Student student = new Student();
			student.setName(branchName);;
			student.setUserId(userId);
			student.setPassword(password);
			student.setGender(gender);
			student.setBranchName(branchName);
			student.setAddress(address);
			student.setRole(Role.STUDENT);
			
			int newStudentId =studentInterfaceImpl.register(student);
			System.out.println(newStudentId+" created successfully.");
			//notificationInterface.sendNotification(NotificationType.REGISTRATION, newStudentId, null,0);
		}
		catch(StudentNotRegisteredException ex)
		{
			logger.error("Something went wrong! "+ex.getStudentName() +" not registered. Please try again");
		}
	}
	private void userLogin() {
		Scanner sc=new Scanner(System.in);
		String userId,password;
		try
		{
			System.out.println("-----------------Login------------------");
			System.out.println("Email:");
			userId=sc.next();
			System.out.println("Password:");
			password=sc.next();
			isValidUser = userInterfaceImpl.verifyCredentials(userId, password);
			
			if(isValidUser)
			{
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
				LocalDateTime myDateObj = LocalDateTime.now();
				String formattedDate = myDateObj.format(myFormatObj);  
				 
				System.out.println("Hello "+userId);
				String role=userInterfaceImpl.getRole(userId);
				Role userRole=Role.stringToName(role);
				switch(userRole)
				{
				case ADMIN:
					System.out.println(formattedDate +" "+ userRole+" Login Successful");
					CRSAdmin adminMenu=new CRSAdmin();
					adminMenu.createMenu();
					break;
				case PROFESSOR:
					System.out.println(formattedDate +" "+userRole+ " Login Successful");
					CRSProfessor professorMenu=new CRSProfessor();
					professorMenu.createMenu(userId);
					
					break;
				case STUDENT:
					System.out.println(formattedDate + " "+userRole+" Login Successful");
					int studentId=studentInterfaceImpl.getStudentId(userId);
					boolean isApproved=studentInterfaceImpl.isApproved(studentId);
					if(isApproved)
					{
						CRSStudent student=new CRSStudent();
						student.create_menu(studentId);
					}
					else
					{
						isValidUser=false;
					}
					break;
				}
				
				
			}
			else
			{
				System.out.println("Invalid Credentials!");
			}
			
		}
		catch(UserNotFoundException ex)
		{
			System.out.println(ex.getMessage());
		}	
	
	
		
	}
}
