package com.lt.client;

import java.util.Scanner;

import com.lt.business.ProfessorInterfaceImpl;

public class CRSProfessor {
	
	public void helloProfessor(){
		int selection = 0;
		ProfessorInterfaceImpl professor = new ProfessorInterfaceImpl();
		while(selection < 4){
		System.out.println("\nHello Professor!\t Welcome to CRS.\n");
		System.out.println("1.Login\n2.View Courses\n3.Add Grades\n4.Exit");
		Scanner scan = new Scanner(System.in);
		 selection = scan.nextInt();
			switch(selection){
			case 1:
				professor.login();
				break;
			case 2:
				professor.viewCourses();
				break;
			case 3:
				professor.addGrades();
				break;
			case 4:
				System.out.println("Bye Professor!");
				break;
			default:
				System.out.println("Please choose the valid input!");
				selection = 0;
				break;
				}
			}
		}
	}
