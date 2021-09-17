package com.lt.contants;

public class Constants {

	public static final String PROFESSORgetStudentData = "SELECT * FROM CRS_STUDENT";
	public static final String PROFESSORgetCourseData = "SELECT C.SNO,C.COURSEID,C.COURSENAME,C.COURSEDESCRIPTION,C.COURSEAMOUNT,P.PROFESSORNAME FROM CRS_COURSE AS C LEFT JOIN CRS_PROFESSOR AS P ON C.PROFESSORID=P.PROFESSORID";
	public static final String PROFESSORgetLoginDetails = "SELECT PROFESSORID,PROFESSORPASSWORD from CRS_PROFESSOR where PROFESSORID=? and PROFESSORPASSWORD=?";
	public static final String PROFESSORgetGradeData = "SELECT G.GRADEID,S.STUDENTID ,S.STUDENTNAME ,G.GRADEPOINTS,G.GRADESTATUS FROM CRS_GRADE AS G INNER JOIN CRS_STUDENT AS S ON G.STUDENTID=S.STUDENTID";
	public static final String PROFESSORaddGrade ="INSERT INTO CRS_GRADE (GRADESTATUS,GRADEPOINTS,STUDENTID) VALUES (?,?,?)";
	public static final String STUDENTaddCourse = "INSERT INTO CRS_COURSE (COURSEID,COURSENAME,COURSEDESCRIPTION) VALUES(?,?,?)";
	public static final String STUDENTdropCourse = "DELETE FROM CRS_COURSE WHERE COURSENAME=?";
	public static final String STUDENTCourseName = "SELECT COURSENAME FROM CRS_COURSE";
}
