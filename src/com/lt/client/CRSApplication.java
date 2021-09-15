package com.lt.client;

import java.util.Scanner;

import com.lt.business.AdminInterfaceImpl;
import com.lt.business.ProfessorInterfaceImpl;
import com.lt.business.StudentInterfaceImpl;

public class CRSApplication {
	public static void main(String[] args){
		System.out.println("Course Registration System");
		System.out.println("---------------------------");
		System.out.println("1.Sign Up\n2.Login\n3.Update Password\n4.Exit");
		Scanner scan = new Scanner(System.in);
		int roleSelection = scan.nextInt();
		
			switch(roleSelection){
			case 1:
				System.out.println("Sign Up");
				StudentInterfaceImpl student1 = new StudentInterfaceImpl();
				student1.signUp();
				break;
			case 2:
				System.out.println("1.Student\n2.Professor\n3.Admin\n4.Exit");
				int input = scan.nextInt();
				switch(input){
				case 1:
					StudentInterfaceImpl student = new StudentInterfaceImpl();
					student.login();
					break;
				case 2:
					ProfessorInterfaceImpl professor = new ProfessorInterfaceImpl();
					professor.login();
					break;
				case 3:
					AdminInterfaceImpl admin = new AdminInterfaceImpl();
					admin.login();
					break;
				case 4:
					System.out.println("Logged out!");
					break;
				}
				break;
			case 3:
				System.out.println("Update Password");
				break;
			case 4:
				System.out.println("Logged out!");
				break;
			default:
				System.out.println("Please choose the valid user!");
			
		}
	}
}
