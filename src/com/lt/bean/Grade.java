package com.lt.bean;

public class Grade {
	public Grade(){}
	public Grade(int gId, boolean gStatus, int gPoints, int sId, String sName){
		this.gradeId = gId;
		this.gradeStatus = gStatus;
		this.gradePoints = gPoints;
		this.studentName = sName;
		this.studentId = sId;
		System.out.println("Student Id:\tStudent Name:\tGrade Points\tGrade Status");
		System.out.println(sId+"\t\t"+sName+"\t\t"+gPoints+"\t\t"+gStatus);
	}
	private int gradeId;
	private boolean gradeStatus;
	private int gradePoints;
	private String studentName;
	private int studentId;
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public boolean isGradeStatus() {
		return gradeStatus;
	}
	public void setGradeStatus(boolean gradeStatus) {
		this.gradeStatus = gradeStatus;
	}
	public int getGradePoints() {
		return gradePoints;
	}
	public void setGradePoints(int gradePoints) {
		this.gradePoints = gradePoints;
	}
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
	
	
}
