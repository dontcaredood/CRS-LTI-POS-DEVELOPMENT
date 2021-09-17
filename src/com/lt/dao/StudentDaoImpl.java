package com.lt.dao;

import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.bean.RegisteredCourses;
import com.lt.bean.Student;
import com.lt.constants.Constants;
import com.lt.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StudentDaoImpl implements StudentDao {

private static void getViewGrade() {
StudentDaoImpl studentDao = new StudentDaoImpl();
List<Grade> grade = studentDao.viewGrade();
for (Grade g : grade) {
//System.out.println(g.getGradeId() + "\t\t  " + g.getStudentId() + "\t\t    " + g.getStudentName() + "\t\t    "
//+ g.getGradePoints() + "\t\t   " + g.getGradeStatus());
}

}


public static List<Course> getViewCourse(){
	return null;

}


public boolean signup(Student student) {
	boolean isSignup = false;
	Connection con = null;
	try {
	String sql = Constants.StudentSignUp;
	con = DBUtils.getConnection();
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, student.getStudentName());
	ps.setString(2, student.getDepartment());
	ps.setString(3, student.getPassword());
	ps.setString(4, "N");
	int rs = ps.executeUpdate();
	isSignup = (rs > 0);
	} catch (Exception e) {
	e.printStackTrace();
	}
	// } finally {
	// DBUtils.closeConnection(con);
	// }
	return isSignup;
}

public HashMap<Integer, String> getLoginDetails() {

Connection con = null;
String sql = Constants.StudentLoginDetails;
HashMap<Integer, String> studentDetails = new HashMap<Integer, String>();
try {
con = DBUtils.getConnection();
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
studentDetails.put(rs.getInt(1),rs.getString(2));
}

} catch (SQLException e) {
System.err.println("Student Login Error!");
}

return studentDetails;
}

public List<Grade> viewGrade() {
Connection con = null;

List<Grade> list = new ArrayList<Grade>();

String sql = "select gradeid,studentId ,studentname ,gradepoints,gradestatus,department from Grade inner join Student on gradeid=studentId";
try {
con = DBUtils.getConnection();
System.out.println(con);
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

System.out.println("Show Grade Data Below");
System.out.println("\nGrade_Id   \t Student Id   \t Student Name   \t Grade Points   \t   Grade Status");

while (rs.next()) {
Grade grade = new Grade();
grade.setStudentId(rs.getInt(4));
grade.setStudentName(rs.getString(6));
//grade.setGradePoints(rs.getInt(2));
//grade.setDepartment(rs.getString(5));
//grade.setGradeStatus("P");
list.add(grade);
}

} catch (Exception e) {
e.printStackTrace();
}
// } finally {
// DBUtils.closeConnection(con);
// }

return list;
}

public List<Course> viewRegisteredCourses() {
    System.out.println("View Course Method");
Connection con = null;

List<Course> list = new ArrayList<Course>();

String sql = "select * from Course";
try {
con = DBUtils.getConnection();
PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

System.out.println("Show Courses Data Below");
System.out.println("\nCourse Id   \t Course Name");

while (rs.next()) {
Course course = new Course();
//course.setCourseId(rs.getInt(1));
course.setCourseName(rs.getString(2));
list.add(course);
}
} catch (Exception e) {
e.printStackTrace();
}
// } finally {
// DBUtils.closeConnection(con);
// }

return list;
}

public boolean addCourse(Course course) {
	Connection con = null;
	String sql = Constants.StudentAddCourse;
	boolean flag = false;
	try {
		con = DBUtils.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, course.getCourseId());
		ps.setString(2, course.getCourseName());
		ps.setString(3, course.getCourseDescription());
		flag = ps.execute();
		System.out.println("Course has been added");
	} catch (SQLException e) {
		// TODO: handle exception
		System.out.println("Student : Error In AddCourse method");
		e.printStackTrace();
	}
	return flag;
}



public boolean dropCourse(String courseName) {
	Connection con = null;
	String sql = Constants.StudentDropCourse;
	String sql2=Constants.StudentCourseName;
	boolean flag = false;
	try {
		con = DBUtils.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, courseName);

		PreparedStatement ps2=con.prepareStatement(sql2);
		ResultSet rs=ps2.executeQuery();

		boolean isCheck=false;

		while(rs.next())
		{
			if(rs.getString(1).equals(courseName))
			{
				isCheck=true;
			}
		}
		if(isCheck) {
		flag = ps.execute();
		System.out.println("Course has been Drop");
		}
		else
		{
			System.out.println("Course Name is not Found in Courses");
		}

	} catch (SQLException e) {
		// TODO: handle exception
		System.out.println("Student : Error In dropCourse method");
		e.printStackTrace();
	}
	return flag;
}

}