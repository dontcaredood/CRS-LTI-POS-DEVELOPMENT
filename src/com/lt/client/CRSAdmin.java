package com.lt.client;

import java.util.Scanner;

public class CRSAdmin {
	public void helloAdmin(){
		int selection = 0;
		while(selection < 4){
		System.out.println("Hello Admin!\t Welcome to CRS.");
		System.out.println("1.Login\n2.Add Professor\n3.Approve Student\n4.Exit");
		Scanner scan = new Scanner(System.in);
		 selection = scan.nextInt();
			switch(selection){
			case 1:
				login();
				break;
			case 2:
				addProfessor();
				break;
			case 3:
				approveStudent();
				break;
			case 4:
				System.out.println("Bye Admin!");
				break;
			default:
				System.out.println("Please choose the valid input!");
				selection = 0;
				break;
			}
		}
		}
	public void login(){
		System.out.println("Admin Login()\n");
		}

	public void addProfessor(){
		System.out.println("Add Professor()\n");
		}

	public void approveStudent(){
		System.out.println("Approve Student()\n");
		}
}
