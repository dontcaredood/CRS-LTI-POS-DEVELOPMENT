package com.lt.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.lt.bean.Course;

public class ProfessorInterfaceImpl implements ProfessorInterface{
	
	public void login(){
		Scanner kb= new Scanner(System.in);
		int userId;
		String pass;
		System.out.println("Professor Login:");
		HashMap<Integer, String> prof = new HashMap<Integer, String>();
		prof.put(101, "pass1");
		prof.put(102, "pass2");
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
				System.out.println("Logged out successfully.");
				i=5;
				break;
			default:
				System.out.println("Please choose the valid user!");
				}
			}
		
	}
	public void viewCourses(){
		System.out.println("View Courses()\n");
			Course c1 = new Course();
			c1.setCourseId(1);
			c1.setCourseName("Java Programming");
			Course c2 = new Course();
			c2.setCourseId(2);
			c2.setCourseName("Theory of Computation");
			Course c3 = new Course();
			c3.setCourseId(3);
			c3.setCourseName("Software Engineering");
			Course c4 = new Course();
			c4.setCourseId(4);
			c4.setCourseName("DBMS");

			List<Course> list = new ArrayList<Course>();
			list.add(c1);
			list.add(c2);
			list.add(c3);
			list.add(c4);
			//Iterator itr = list.iterator();
			System.out.println("Course ID:\t Course Name");
			System.out.println("------------------------------");
			for(Course c : list){
				System.out.println(c.getCourseId()+"\t\t "+c.getCourseName());
			}
		}

	public void addGrades(){
		System.out.println("Add Grades()\n");
		}

	public void viewStudent() {
		System.out.println("View Student()\n");	
		}
}
