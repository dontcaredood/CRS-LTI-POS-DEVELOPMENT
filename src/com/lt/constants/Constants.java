package com.lt.constants;

public class Constants {
	//Professor SQL Queries
	public static final String ProfessorGetStudentData = "SELECT * FROM CRS_STUDENT";
	public static final String ProfessorGetCourseData = "SELECT * FROM CRS_COURSE";
	public static final String ProfessorGetLoginDetails = "select professorId,professorPassword from CRS_PROFESSOR ";
	public static final String ProfessorGetGradeData = "SELECT G.GID,S.SID ,S.SNAME ,G.POINTS,G.STATUS FROM CRS_GRADE AS G INNER JOIN CRS_STUDENT AS S ON G.STDID=S.SID";
	public static final String ProfessorAddGrade ="INSERT INTO CRS_GRADE (GRADESTATUS,GRADEPOINTS,STUDENTID) VALUES (?,?,?)";
	//Admin SQL Queries
	public static final String AdminLogin = "SELECT * FROM CRS_ADMIN;";
	public static final String AdminAddProfessor = "INSERT INTO CRS_PROFESSOR (professorName,professorPassword,professorDepartment)VALUES (?,?,?)";
	public static final String AdminShowCourses = "SELECT * FROM CRS_COURSE";
	public static final String AdminShowProfessors = "SELECT * FROM CRS_PROFESSOR";
	public static final String AdminAddCourse = "INSERT INTO CRS_COURSE (courseId,courseName,courseDescription)VALUES (?,?,?)";
	public static final String AdminRemoveCourse = "DELETE FROM CRS_COURSE where courseId =?";
	public static final String AdminGetGradeCard = "SELECT * FROM CRS_GRADE";
	public static final String AdminGetStudentDetails = "SELECT * FROM CRS_STUDENT WHERE isActive ='N'";
	public static final String AdminApproveStudent = "UPDATE CRS_STUDENT SET isActive = ? WHERE STUDENTID = ?";
	//Student SQL Queries
	public static final String StudentSignUp = "INSERT INTO CRS_STUDENT (studentname,studentDepartment,studentPassword,isActive)values(?,?,?,?)";
	public static final String StudentAddCourse = "INSERT INTO CRS_COURSE (COURSEID,COURSENAME,COURSEDESCRIPTION) VALUES(?,?,?)";
	public static final String StudentDropCourse = "DELETE FROM CRS_COURSE WHERE COURSENAME=?";
	public static final String StudentLoginDetails = "SELECT STUDENTID, STUDENTPASSWORD FROM CRS_STUDENT";
	public static final String StudentCourseName = "SELECT COURSENAME FROM CRS_COURSE";
}
