package com.lt.business;

import java.util.*;

import com.lt.bean.Course;
import com.lt.bean.GradeCard;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.dao.AdminDaoImpl;

public class AdminInterfaceImpl implements AdminInterface{
	
	AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
	public void login(){
		try {
			Scanner kb= new Scanner(System.in);
			int userId;
			String pass;
			System.out.println("Admin Login:");
			System.out.println("----------------------------------------");
			HashMap<Integer, String> prof = adminDaoImpl.getLoginDetails();
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
			System.out.println("\nWelcome Admin!\n1.Add Professor\n2.Approve Student\n3.Generate GradeSheet\n4.Logout");
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
				System.out.println("Logged out successfully.");
				i=5;
				break;
			default:
				System.out.println("Please choose the valid user!");
				}
			}
		}
	public void addProfessor() {
		Professor p1 = new Professor();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter professor Details");
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

		
	}

	public String approveStudent() {
		// TODO Auto-generated method stub
		
		Student s1=new Student();
		s1.setUserId(100);
		s1.setStudentName("Rehan");
		s1.setDepartment("Computer Science");
		s1.setPassword("rehan123");
		
		String status="";
		
		System.out.println("Student Approval Status");
		if(s1.getStudentName()!=""&&s1.getStudentName()!=null&&s1.getDepartment()!=""&&s1.getDepartment()!=null&&s1.getPassword()!="")
		{
			status="Approved";
		}else{
			status="Not Approved";		
		}
		
		
		return status;
	}

	public void addCourses(Course course) {
		// TODO Auto-generated method stub
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
			System.out.println("Professor Added Sucessfully");
		}else{
			System.out.println("Error Adding Professor");
		}
	}

	public boolean removeCourse(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public void generateReport() {
		// TODO Auto-generated method stub
		
		GradeCard gc1=new GradeCard();
		gc1.setGradePoints(7);
		gc1.setStudentDepartment("Computer Science");
		gc1.setStudentId(100);
		gc1.setStudentName("Rehan");
		gc1.setRemarks("Pass");
		
		GradeCard gc2=new GradeCard();
		gc2.setGradePoints(8);
		gc2.setStudentDepartment("IT Science");
		gc2.setStudentId(101);
		gc2.setStudentName("Tushar");
		gc2.setRemarks("Fail");
		
		List<GradeCard> list = new ArrayList<GradeCard>();
		list.add(gc1);
		list.add(gc2);
		for(GradeCard grade : list){
			System.out.println("Student Id: "+grade.getStudentId());
			System.out.println("Student Name: "+grade.getStudentName());
			System.out.println("Department :"+grade.getStudentDepartment());
			System.out.println("Grade :"+grade.getGradePoints());
			System.out.println("Remarks: "+grade.getRemarks());
			System.out.println("---------------------------------------");
		}
//		Iterator itr = list.iterator();
//		System.out.println("----------------Grade Card Report Generated-------------------");
//		while(itr.hasNext())
//		{
//			GradeCard grade=(GradeCard)itr.next();
//			System.out.println("Student Id: "+grade.getStudentId());
//			System.out.println("Student Name: "+grade.getStudentName());
//			System.out.println("Department :"+grade.getStudentDepartment());
//			System.out.println("Grade :"+grade.getGradePoints());
//			System.out.println("Remarks: "+grade.getRemarks());
//			System.out.println("---------------------------------------");
//			
//		}
	}
	
	
}
