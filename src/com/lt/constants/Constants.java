package com.lt.constants;

public class Constants {
	
	
	public static final String AdminLogin = "SELECT * FROM CRS_ADMIN;";
	public static final String AdminAddProfessor = "INSERT INTO CRS_PROFESSOR (professorName,professorPassword,professorDepartment)VALUES (?,?,?)";
	public static final String AdminAddCourse = "INSERT INTO CRS_COURSE (courseId,courseName,courseDesc)VALUES (?,?,?)";

}
