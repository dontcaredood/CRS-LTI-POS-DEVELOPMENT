package com.lt.business;

import java.util.*;

import com.lt.bean.Course;
import com.lt.bean.GradeCard;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.client.CRSApplication;
import com.lt.dao.AdminDaoImpl;

public class AdminInterfaceImpl implements AdminInterface{
	
	AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
	public void login(){
		try {
			Scanner kb= new Scanner(System.in);
			int userId;
			String pass;
			System.out.println("Admin Login:");
			HashMap<Integer, String> prof = adminDaoImpl.getLoginDetails();
			System.out.println("Please enter User Id: ");
			userId=kb.nextInt();
			if(prof.containsKey(userId)){
				System.out.println("Please enter Password: ");
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
			System.out.println("\nWelcome Admin!\n1.Add Professor\n2.Approve Student\n3.Generate GradeSheet\n4.Add Courses\n"
					+ "5.Remove Courses\n6.Logout");
			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();
			switch(input){
			case 1:
				addProfessor();
				break;
			case 2:
				approveStudent();
				break;
			case 3:
				generateReport();
				break;
			case 4:
				addCourses();
				break;
			case 5:
				removeCourse();
				break;
			case 6:
				System.out.println("Logged out successfully.\n");
				new CRSApplication().main(null);
				i=5;
				break;
			default:
				System.out.println("Please choose the valid user!");
				}
			}
		}
	public void addProfessor() {
		showProfessors();
		Professor p1 = new Professor();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter professor Details:");
		System.out.println("Enter professor Name:");
		p1.setProfessorName(scan.nextLine());
		System.out.println("Enter professor Password:");
		p1.setProfessorPassword(scan.nextLine());
		System.out.println("Enter professor Department:");
		p1.setProfessorDepartment(scan.nextLine());
		boolean isAdded = adminDaoImpl.addProfessorData(p1);
		if(isAdded){
			System.out.println("Professor Added Sucessfully");
		}else{
			System.out.println("Error Adding Professor");
		}
		showProfessors();
	}

	public void approveStudent() {
		List<Student> studentList = adminDaoImpl.getStudentDetails();
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		if(studentList.isEmpty()){
			System.out.println("No Pending approvals!!");
		}else{
			int listCount = studentList.size();
			while(listCount > 0 ){
				System.out.println("__________________________________________________________________");
				System.out.println("Student Details:\nStudent ID :\t\tStudent Name\t\tStudent Department");
				for(Student s : studentList){
					System.out.println(s.getStudentId()+"\t\t\t"+s.getStudentName()+"\t\t\t"+s.getDepartment());
				}
				System.out.println("__________________________________________________________________");
				System.out.println("Enter the Student Id to approve");
				int studentId = scan.nextInt();
				System.out.println("Approve or Deny the student? \nEnter 1 to approve\nEnter 2 to deny:");
				int choice = scan.nextInt();
				switch(choice){
				case 1:
					flag = adminDaoImpl.approveStudent(studentId,"Y");
					if(flag){
						System.out.println(studentId+" has been approved successfully!");
						listCount--;
						studentList.remove(0);
					}
					break;
				case 2:
					adminDaoImpl.approveStudent(studentId,"R");
					if(flag){
						System.out.println(studentId+" has been rejected sucessfully!");
						listCount--;
						studentList.remove(0);
					}
					
				}
				
				
			}
			
		}
		
		
		
		
		
	}

	public void addCourses() {
		showCourses();
		System.out.println("Add Courses:");
		Course courseObj = new Course();	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Course Details");
		System.out.println("Enter Course ID:");
		courseObj.setCourseId(scan.nextLine());
		System.out.println("Enter Course Name:");
		courseObj.setCourseName(scan.nextLine());
		System.out.println("Enter Course Description:");
		courseObj.setCourseDescription(scan.nextLine());
		boolean isCourseAdded = adminDaoImpl.addCourses(courseObj);
		if(isCourseAdded){
			System.out.println(courseObj.getCourseName()+" Course Added Sucessfully\n");
		}else{
			System.out.println("Error Adding Course");
		}
		showCourses();
	}

	public void removeCourse() {
		showCourses();
		System.out.println("Remove Course:");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Course ID");
		String courseId = scan.nextLine();
		boolean isCourseAdded = adminDaoImpl.removeCourses(courseId);
		if(isCourseAdded){
			System.out.println(courseId+" Course Removed Sucessfully");
		}else{
			System.out.println("Error removing course");
		}
		showCourses();
	}

	public void generateReport() {
		// TODO Auto-generated method stub
		System.out.println("Generate Report:");
		List<GradeCard> list = adminDaoImpl.getGradeCardDetails();
		for(GradeCard grade : list){
			System.out.println("Student Id: "+grade.getStudentId());
			System.out.println("Student Name: "+grade.getStudentName());
			System.out.println("Department :"+grade.getStudentDepartment());
			System.out.println("Grade :"+grade.getGradePoints());
			System.out.println("Remarks: "+grade.getRemarks());
			System.out.println("---------------------------------------");
		}
	}
	
	public void showCourses(){
		ArrayList<Course> courseList = adminDaoImpl.showCourses();
		if(courseList.isEmpty()){System.out.println("No Courses Availabe!");}else{
			System.out.println("__________________________________________________________________");
			System.out.println("Courses:\nCourse ID :\t\tCourse Name\t\tCourse Description");
			for(Course c : courseList){
				System.out.println(c.getCourseId()+"\t\t\t"+c.getCourseName()+"\t\t\t"+c.getCourseDescription());
			}
			System.out.println("__________________________________________________________________");

		}
	}
	public void showProfessors(){
		ArrayList<Professor> professorList = adminDaoImpl.showProfessors();
		if(professorList.isEmpty()){System.out.println("No Courses Availabe!");}else{
			System.out.println("Professor List:\nProfessor ID :\t\t\tProfessor Name\t\t\tProfessor Department\t\t2\tPassword");
			for(Professor c : professorList){
				System.out.println(c.getProfessorId()+"\t\t\t\t"+c.getProfessorName()+"\t\t\t\t"+c.getProfessorDepartment()+"\t\t\t\t"+c.getProfessorPassword());
			}
			System.out.println("__________________________________________________________________");

		}
	}
}
