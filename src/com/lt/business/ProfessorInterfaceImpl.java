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

public class ProfessorInterfaceImpl implements ProfessorInterface{
	//Professor Login
	public void login(){
		try {
			Scanner kb= new Scanner(System.in);
			int userId;
			String pass;
			System.out.println("Professor Login:");
			System.out.println("----------------------------------------");
			HashMap<Integer, String> prof = getLoginDetails();
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
	//Menu for Professor
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
	//Display the courses available
	public void viewCourses(){
			System.out.println("View Courses:\n");
			List<Course> list = getCoursesData();
			System.out.println("Course ID:\t Course Name");
			System.out.println("----------------------------------------");
			for(Course c : list){
				System.out.println(c.getCourseId()+"\t\t "+c.getCourseName());
			}
			System.out.println("----------------------------------------");
		}
	//Add Grades to the student
	public void addGrades(){
		String studentName;;
		int studentId, grade;
		Boolean gStatus ;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Student Id:");
		studentId = sc.nextInt();
		studentName = getStudentName(studentId);
		
		if(studentName!=null) {
			System.out.println("Enter Grade:");
			grade =sc.nextInt();
			if(grade < 4){
				gStatus = false;
				}else{
					gStatus = true;
				}
			new Grade( studentId,  gStatus,  grade,  studentId,  studentName);
		}
	}
	
	
	// Display grades of the students
	public void showGrades(){
		System.out.println("Add Grades:\n");
		System.out.println("View Student:\n");	
		List<Grade> grade = getGradeData();	    
		System.out.println("Student ID\t Student Name\t\t Grade \t\tStatus ");
		System.out.println("-------------------------------------------------");
		for(Grade c : grade){
			System.out.println(c.getStudentId()+"\t\t"+c.getStudentName()+"\t\t\t"+c.getGradePoints()+"\t"+(c.isGradeStatus()==true?"Pass":"Fail"));
		}
		System.out.println("-------------------------------------------------");
		addGrades();
	}
	public void viewStudent() {
		System.out.println("View Student:\n");	
		List<Student> list = getStudentsData();
		System.out.println("Student ID\t Student Name\t\t Department");
		System.out.println("-------------------------------------------------");
		for(Student c : list){
			System.out.println(c.getStudentId()+"\t\t"+c.getStudentName()+"\t\t\t"+c.getDepartment());
		}
		System.out.println("-------------------------------------------------");
		}
	
	//Data layer
	public List<Student> getStudentsData(){
		Student s1 = new Student(501,"Amy","CS");
		Student s2 = new Student(502,"Ben","EE");
		Student s3 = new Student(503,"Charles","Bio");
		Student s4 = new Student(504,"Denver","EC");
		Student s5 = new Student(505,"Emilia","CS");	
		List<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		return list;
	} 
	public List<Course> getCoursesData(){
		Course c1 = new Course();
		c1.setCourseId(101);
		c1.setCourseName("Java Programming");
		Course c2 = new Course();
		c2.setCourseId(102);
		c2.setCourseName("Theory of Computation");
		Course c3 = new Course();
		c3.setCourseId(103);
		c3.setCourseName("Software Engineering");
		Course c4 = new Course();
		c4.setCourseId(104);
		c4.setCourseName("DBMS");
		Course c5 = new Course();
		c5.setCourseId(105);
		c5.setCourseName("Web Development");

		List<Course> list = new ArrayList<Course>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		return list;
	} 
	public HashMap<Integer, String> getLoginDetails(){
		HashMap<Integer, String> prof = new HashMap<Integer, String>();
		prof.put(101, "pass1");
		prof.put(102, "pass2");
		return prof;
	}
	public List<Grade> getGradeData(){
		Grade s1 = new Grade(1,true,8,501,"Amy");
		Grade s2 = new Grade(2,true,7,502,"Ben");
		Grade s3 = new Grade(3,true,9,503,"Charles");
		Grade s4 = new Grade(4,true,8,504,"Denver");
		Grade s5 = new Grade(5,true,7,505,"Emilia");	
		List<Grade> list = new ArrayList<Grade>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		return list;
	} 
	public String getStudentName(int id){
		List<Student> list = getStudentsData();
		String studentName = null;
		for(Student s : list){
			if(s.getStudentId()== id){
				 studentName = s.getStudentName();
			}
		}
		if(studentName==null){
			System.out.println("Student not found!");
		}
		return studentName;
	}
}
