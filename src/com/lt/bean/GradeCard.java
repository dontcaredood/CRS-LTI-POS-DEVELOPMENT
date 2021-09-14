package com.lt.bean;

public class GradeCard extends Grade{
	private boolean gradeStatus;
	private String remarks;
	private String studentName;
	private String studentDepartment;
	private int studentId;
	public boolean isGradeStatus() {
		return gradeStatus;
	}
	public void setGradeStatus(boolean gradeStatus) {
		this.gradeStatus = gradeStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentDepartment() {
		return studentDepartment;
	}
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	}
