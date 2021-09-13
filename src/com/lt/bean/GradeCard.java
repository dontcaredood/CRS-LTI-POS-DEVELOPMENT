package com.lt.bean;

public class GradeCard {
	private boolean gradeStatus;
	private String remarks;
	private String studentName;
	private String studentDepartment;
	private int studentId;
	
	public final boolean isGradeStatus() {
		return gradeStatus;
	}
	public final void setGradeStatus(boolean gradeStatus) {
		this.gradeStatus = gradeStatus;
	}
	public final String getRemarks() {
		return remarks;
	}
	public final void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public final String getStudentName() {
		return studentName;
	}
	public final void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public final String getStudentDepartment() {
		return studentDepartment;
	}
	public final void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	public final int getStudentId() {
		return studentId;
	}
	public final void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
}
