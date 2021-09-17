package com.lt.bean;

public class Grade {
	public Grade(){}
	public Grade( String gStatus, float gPoints, int sId){
		this.setGradePoints(gPoints);
		this.studentId = sId;
		this.gradeStatus = gStatus;
		System.out.println("Student Id:\tGrade Points\tGrade Status");
		System.out.println(sId+"\t\t"+gPoints+"\t\t"+gStatus);
	}
	private int gradeId;
	private double gradePoints;
	private String studentName;
	private int studentId;
	private String gradeStatus;
	
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
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
	public double getGradePoints() {
		return gradePoints;
	}
	public void setGradePoints(double gradePoints) {
		this.gradePoints = gradePoints;
	}
	public String getGradeStatus() {
		return gradeStatus;
	}
	public void setGradeStatus(String gradeStatus) {
		this.gradeStatus = gradeStatus;
	}
	
	
}
