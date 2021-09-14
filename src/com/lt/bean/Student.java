package com.lt.bean;

public class Student extends User{
	
	public Student(){}
	public Student(int id, String name, String department){
		this.studentId = id;
		this.studentName = name;
		this.department = department;
	}
	private String studentName;
	private int studentId;
	private String department;
	private String password;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
