package com.lt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.bean.Student;
import com.lt.constants.Constants;
import com.lt.utils.DBUtils;

public class ProfessorDaoImpl implements ProfessorDao {

public HashMap<Integer, String> getLoginDetails() {
		
		Connection con = null;
		String sql = Constants.ProfessorGetLoginDetails;
		HashMap<Integer, String> adminDetails = new HashMap<Integer, String>();
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				adminDetails.put(rs.getInt(1),rs.getString(2));
			}

		} catch (SQLException e) {
			System.err.println("Professor : Login Error!");
		}

		return adminDetails;
	}

	public List<Student> getStudentData() {
		Connection con = null;
		List<Student> list = new ArrayList<Student>();
		String sql = Constants.ProfessorGetStudentData;
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt(1));
				student.setStudentName(rs.getString(2));
				student.setDepartment(rs.getString(3));
				student.setPassword(rs.getString(5));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Professor : Error In getStudentData");
		}

		return list;
	}
	
	/*public List<Course> getCourseData() {
		Connection con = null;
		List<Course> list = new ArrayList<Course>();
		String sql = Constants.PROFESSORgetCourseData;
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("Show Courses Data Below");
			System.out.println("\nCourse Id   \t Course Name");
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getString(1));
				course.setCourseName(rs.getString(2));
				course.setCourseDescription(rs.getString(3));
				list.add(course);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Professor : Error In getCourseData");
		}

		return list;
	}*/

	public List<Grade> getGradeData() {
		// TODO Auto-generated method stub
		Connection con = null;
		List<Grade> list = new ArrayList<Grade>();
		String sql = Constants.ProfessorGetGradeData;
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("Show Grade Data Below");
			System.out.println("\nGrade_Id   \t Student Id   \t Student Name   \t Grade Points   \t   Grade Status");
			while (rs.next()) {
				Grade grade = new Grade();
				grade.setGradeId(rs.getInt(1));
				grade.setStudentId(rs.getInt(2));
				grade.setStudentName(rs.getString(3));
				grade.setGradePoints(rs.getInt(4));
				list.add(grade);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Professor : Error In getGradeData");
		}

		return list;
	}

	public boolean addGrade(Grade grade) {
			Connection con = null;
			String sql = Constants.ProfessorAddGrade;
			boolean flag = false;
			try {
				con = DBUtils.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, grade.getGradeStatus());
				ps.setDouble(2, grade.getGradePoints());
				ps.setInt(3, grade.getStudentId());
				int rs = ps.executeUpdate();
				if(rs>0) {flag = true;}
				System.out.println("Student Grade Added Successfully!");

			} catch (SQLException e) {
				System.out.println("Professor : Error In AddGrade");
				e.printStackTrace();
			}
			return flag;
	}
}