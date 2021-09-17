package com.lt.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.bean.Student;
import com.lt.client.CRSApplication;
import com.lt.dao.AdminDaoImpl;
import com.lt.dao.ProfessorDaoImpl;

public class ProfessorInterfaceImpl implements ProfessorInterface{
	AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
	ProfessorDaoImpl professorDaoImpl = new ProfessorDaoImpl();
	public void login(){
		try {
			Scanner kb= new Scanner(System.in);
			int userId;
			String pass;
			System.out.println("Professor Login:");
			System.out.println("----------------------------------------");
			HashMap<Integer, String> prof = professorDaoImpl.getLoginDetails();
			System.out.println("Enter UserId: ");
			userId=kb.nextInt();
			if(prof.containsKey(userId)){
				System.out.println("Enter Password: ");
				pass=kb.next();
				if(pass.equalsIgnoreCase(prof.get(userId))){
					showMenu();
					}else{
						System.out.println("Invalid Password.Please try again!\n");
						login();
						}
				}else{
				System.out.println("Invalid Username.Please try again!\n");
				}
		} catch (InputMismatchException e) {
			System.out.println("UserId should be numeric value!\n\n");
			login();
		} catch (Exception ex){
				System.out.println(ex.toString());
		}
	
		}
	
	public void showMenu(){
		int i = 0;
		while(i<4){
			System.out.println("\nWelcome Professor!\n1.View Courses\n2.View Student\n3.Add Grades\n4.Logout");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			switch(input){
			case 1:
				viewCourses();
				break;
			case 2:
				viewStudent();
				break;
			case 3:
				addGrades();
				break;
			case 4:
				System.out.println("Logged out successfully.\n");
				i=5;
				new CRSApplication().main(null);
				break;
			default:
				System.out.println("Please choose the valid user!");
				}
			}
		}
	
	public void viewCourses(){
			System.out.println("View Courses:\n");
			List<Course> list = adminDaoImpl.showCourses();
			System.out.println("Course ID:\t Course Name");
			System.out.println("----------------------------------------");
			for(Course c : list){
				System.out.println(c.getCourseId()+"\t\t "+c.getCourseName());
			}
			System.out.println("----------------------------------------");
		}
	
	public void addGrades(){
		int studentId;
		float grade;
		String gStatus ;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Student Id:");
		studentId = sc.nextInt();
		if(studentId!=0) {
			System.out.println("Enter Grade:");
			grade =sc.nextFloat();
			if(grade < 4){
				gStatus = "Fail";
				}else{
					gStatus = "Pass";
				}
			Grade gradeObject = new Grade(gStatus,  grade,  studentId);
			professorDaoImpl.addGrade(gradeObject);
		}
	}
	
	
	public void showGrades(){
		System.out.println("Add Grades:\n");
		System.out.println("View Student:\n");	
		List<Grade> grade = professorDaoImpl.getGradeData();	    
		System.out.println("Student ID\t Student Name\t\t Grade \t\tStatus ");
		System.out.println("-------------------------------------------------");
		for(Grade c : grade){
			System.out.println(c.getStudentId()+"\t\t"+c.getStudentName()+"\t\t\t"+c.getGradePoints());
		}
		System.out.println("-------------------------------------------------");
		addGrades();
	}
	
	public void viewStudent() {
		System.out.println("View Student:\n");	
		List<Student> list = professorDaoImpl.getStudentData();
		System.out.println("Student ID\t Student Name\t\t Department");
		System.out.println("-------------------------------------------------");
		for(Student c : list){
			System.out.println(c.getStudentId()+"\t\t"+c.getStudentName()+"\t\t\t"+c.getDepartment());
		}
		System.out.println("-------------------------------------------------");
		}
	

}
