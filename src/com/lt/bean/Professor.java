package com.lt.bean;

public class Professor extends User{
	private int professorId;
	private String professorName;
	private String professorPassword;
	private String professorDepartment;
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getProfessorPassword() {
		return professorPassword;
	}
	public void setProfessorPassword(String professorPassword) {
		this.professorPassword = professorPassword;
	}
	public String getProfessorDepartment() {
		return professorDepartment;
	}
	public void setProfessorDepartment(String professorDepartment) {
		this.professorDepartment = professorDepartment;
	}
	
	
}
