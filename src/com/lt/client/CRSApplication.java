package com.lt.client;

import java.util.Scanner;

import com.lt.business.ProfessorInterfaceImpl;

public class CRSApplication {
	public static void main(String[] args){
		System.out.println("Course Registration System");
		System.out.println("1.Sign Up\n2.Login\n3.Update Password\n4.Exit");
		Scanner scan = new Scanner(System.in);
		int roleSelection = scan.nextInt();
		
			switch(roleSelection){
			case 1:
				System.out.println("Sign Up");
				break;
			case 2:
				ProfessorInterfaceImpl professor = new ProfessorInterfaceImpl();
				professor.login();
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
