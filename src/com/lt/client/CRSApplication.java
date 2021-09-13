package com.lt.client;

import java.util.Scanner;

public class CRSApplication {
	public static void main(String[] args){
		System.out.println("Course Registration System\n");
		System.out.println("User Selection\n1.Student\n2.Professor\n3.Admin");
		Scanner scan = new Scanner(System.in);
		int roleSelection = scan.nextInt();
		
			switch(roleSelection){
			case 1:
				CRSStudent student = new CRSStudent();
				student.helloStudent();	
				break;
			case 2:
				CRSProfessor professor = new CRSProfessor();
				professor.helloProfessor();
				break;
			case 3:
				CRSAdmin admin = new CRSAdmin();
				admin.helloAdmin();
				break;
			default:
				System.out.println("Please choose the valid user!");
			
		}
	}
}
