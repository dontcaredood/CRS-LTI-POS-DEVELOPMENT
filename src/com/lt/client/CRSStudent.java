package com.lt.client;

import java.util.Scanner;

public class CRSStudent {
	public void helloStudent(){
	int selection = 0;
	while(selection < 4){
		System.out.println("\nHello Student!\t Welcome to CRS.\n");
		System.out.println("1.Login\n2.View Grade\n3.Register Courses\n4.Exit");
		Scanner scan = new Scanner(System.in);
		selection = scan.nextInt();
			switch(selection){
			case 1:
				login();
				break;
			case 2:
				viewGrade();
				break;
			case 3:
				registerCourses();
				break;
			case 4:
				System.out.println("Bye Student!");
				break;
			default:
				System.out.println("Please choose the valid input!");
				selection = 0;
				break;
				}
			}
	}
	public void login(){
		System.out.println("Login\n");
		}

	public void viewGrade(){
		System.out.println("View Grade\n");
		}

	public void registerCourses(){
		System.out.println("Register Courses\n");
		}
	
}
