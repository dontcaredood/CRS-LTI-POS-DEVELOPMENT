package com.lt.contants;

public class Constants {

	public static final String PROFESSORgetStudentData = "SELECT * FROM STUDENT";
	public static final String PROFESSORgetCourseData = "SELECT * FROM COURSE";
	public static final String PROFESSORgetLoginDetails = "select USERNAME,PASSWORD from PROFESSOR where USERNAME=? and PASSWORD=?";
	public static final String PROFESSORgetGradeData = "SELECT G.GID,S.SID ,S.SNAME ,G.POINTS,G.STATUS FROM GRADE AS G INNER JOIN STUDENT AS S ON G.STDID=S.SID";
	
}
