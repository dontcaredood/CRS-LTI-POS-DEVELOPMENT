package com.lt.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.lt.bean.Course;
import com.lt.bean.GradeCard;
import com.lt.bean.Student;

public class StudentInterfaceImpl implements StudentInterface{
	
	public void signUp() {
		
		//String pass;
		System.out.println("Student signUp:");
		System.out.println("----------------------------------------");
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("---Welcome----");
		System.out.println("Enter Student Name");
		String st=sc.next();
		
	//	String stdept=sc.next();
		System.out.println("Enter StudentDept::" );
		String stdept=sc.next();
		
		System.out.println("Enter Student Password");
		String stpassword=sc.next();
	
		System.out.println("Enter Student Confirm Password");
		String stconfirmpwd=sc.next();
		
				
		if(stpassword.equals(stconfirmpwd)) {
			System.out.println(st+" "+"Successfully signed up !!");
			
		}
		else
		{
			System.out.println("Not succesfully registered! Mismatch the password and confirm password !!");
			signUp();
		}
		 
		
		
		
		
	}

	
	public void login(){
		
			try {
				Scanner kb= new Scanner(System.in);
				int userId;
				String pass;
				System.out.println("Student Login:");
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
	
	public HashMap<Integer, String> getLoginDetails(){
		HashMap<Integer, String> student = new HashMap<Integer, String>();
		student.put(111, "user1");
		student.put(112, "user2");
		return student;
	}
	
	public void showMenu(){
		int i = 0;
		while(i<4){
			System.out.println("\nWelcome student!\n1.View Grade\n2. Register Courses\n3.Logout");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			switch(input){
			case 1:
				viewGrade();
				break;
			case 2:
				registerCourses();
				break;
			case 3:
				System.out.println("Logged out successfully.");
				i=5;
				break;
			default:
				System.out.println("Please choose the valid user!");
				}
			}
		}
		
	public void viewGrade(){
		System.out.println("Student View Grade\n");
		List<GradeCard> studentGradeList =getStudentsGradeData();
		if(studentGradeList.size()>0) {
			System.out.println("Student ID\t Student Name\t\t Grade \t\t Department");
			System.out.println("----------------------------------------------------------------------------");
			for(GradeCard c : studentGradeList){
				System.out.println(c.getStudentId()+"\t\t"+c.getStudentName()+"\t\t\t"+c.getGradePoints()+"\t\t\t"+c.getStudentDepartment());
			}
			System.out.println("-----------------------------------------------------------------------------");
			}
		}
	
         public List<GradeCard> getStudentsGradeData() {

			List<GradeCard> gradeList = new ArrayList<GradeCard>();
			GradeCard g1 = new GradeCard();
			g1.setStudentId(101);
			g1.setGradePoints(7);
			g1.setStudentName("dhana");
			g1.setStudentDepartment("ESE");
			gradeList.add(g1);

			GradeCard g2 = new GradeCard();
			g2.setStudentId(102);
			g2.setGradePoints(6);
			g2.setStudentName("ram");
			g2.setStudentDepartment("ESE");
			gradeList.add(g2);

			GradeCard g3 = new GradeCard();
			g3.setStudentId(103);
			g3.setGradePoints(8);
			g3.setStudentName("john");
			g3.setStudentDepartment("EEE");
			gradeList.add(g3);

			return gradeList;

		}
         
         
		public void registerCourses() {
			System.out.println("View Courses\n");
			List<Course> courseList = getCourseData();
			System.out.println("courseId \t courseName \t ");
			System.out.println("----------------------------------------------------------------");
			for (Course crs : courseList) {
				System.out.println(crs.getCourseId() + "\t\t" + crs.getCourseName() + "");
			}
			System.out.println("------------------------------------------------------------------");
			Scanner sc = new Scanner(System.in);
			List<String> selectedCourses = new ArrayList<String>();
			for(int i =1; i<=4; i++){
				System.out.println("Enter course "+i+":");
				String c1=sc.next();
				selectedCourses.add(c1);
			}
//			System.out.println("enter course 1:");
//			String c1=sc.next();
//			System.out.println("enter course 2:");
//			String c2 = sc.next();
//			System.out.println("enter course 3:");
//			String c3 = sc.next();
//			System.out.println("enter course 4:");
//			String c4 = sc.next();
//			System.out.println("enter course 5:");
//			String c5 = sc.next();
//			System.out.println("enter course 6:");
//			String c6 = sc.next();

			System.out.println("Student Registered Courses");


			System.out.println(
					"--------------------------------------------------------------------------------------------------------");
			for(int i = 0; i < selectedCourses.size();i++){
				System.out.println("Course "+i+1+" : "+selectedCourses.get(i));
			}
//			System.out.println("\t" + c1 + "\t\t" + c2 + "\t\t" + c3 + "\t\t" + c4 + " \t\t"
//					+ c5 + "\t\t" + c6);
         
         
         
         }
		public List<Course> getCourseData(){
			List<Course> courseList = new ArrayList<Course>();
			Course cr = new Course();

			cr.setCourseId(10);
			cr.setCourseName("java");
			cr.setCourseCatalogId(1);
			courseList.add(cr);

			Course cr1 = new Course();
			cr1.setCourseId(11);
			cr1.setCourseName(".net");
			cr1.setCourseCatalogId(1);
			courseList.add(cr1);

			Course cr2 = new Course();
			cr2.setCourseId(12);
			cr2.setCourseName("html");
			cr2.setCourseCatalogId(1);
			courseList.add(cr2);

			Course cr3 = new Course();
			cr3.setCourseId(13);
			cr3.setCourseName("microservices");
			cr3.setCourseCatalogId(1);
			courseList.add(cr3);

			Course cr4 = new Course();
			cr4.setCourseId(14);
			cr4.setCourseName("springboot");
			cr4.setCourseCatalogId(1);
			courseList.add(cr4);

			Course cr5 = new Course();
			cr5.setCourseId(15);
			cr5.setCourseName("css");
			cr5.setCourseCatalogId(2);
			courseList.add(cr5);

			Course cr6 = new Course();
			cr6.setCourseId(16);
			cr6.setCourseName("c");
			cr6.setCourseCatalogId(2);
			courseList.add(cr6);

			Course cr7 = new Course();
			cr7.setCourseId(17);
			cr7.setCourseName("angular");
			cr7.setCourseCatalogId(2);
			courseList.add(cr7);
			return courseList;

		}
		public void addCourses() {
			// TODO Auto-generated method stub
			
		}

		public void dropCourses() {
			// TODO Auto-generated method stub
			
		}   
}