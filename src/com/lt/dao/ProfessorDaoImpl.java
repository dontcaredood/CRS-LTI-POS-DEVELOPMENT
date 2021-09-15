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
import com.lt.utils.DBUtils;

public class ProfessorDaoImpl implements ProfessorDao {

	@Override
	public List<Student> getStudentData() {
		// TODO Auto-generated method stub
		Connection con = null;

		List<Student> list = new ArrayList<Student>();

		String sql = "select * from Student";
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			System.out.println("Show Student Data Below");
			System.out.println(
					"\nStudennt Id   \t Student Name   \t Student Department   \t   Student Username    \t Student Password");

			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setDepartment(rs.getString(3));
				student.setUsername(rs.getString(4));
				student.setPassword(rs.getString(5));
				list.add(student);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return list;
	}

	@Override
	public List<Course> getCourseData() {
		// TODO Auto-generated method stub

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
				course.setCid(rs.getInt(1));
				course.setName(rs.getString(2));
				list.add(course);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return list;
	}

	@Override
	public void getLoginDetails(String username, String password) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "select username,password from users where username=? and password=?";
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				if (username.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
					System.out.println("You have Login Successfully");
				}

			} else {
				System.out.println("Login Failed Try Again!!!");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<Grade> getGradeData() {
		// TODO Auto-generated method stub
		Connection con = null;

		List<Grade> list = new ArrayList<Grade>();

		String sql = "select g.gid,s.sid ,s.sname ,g.points,g.status from Grade as g inner join Student as s on g.stdid=s.sid";
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			System.out.println("Show Grade Data Below");
			System.out.println("\nGrade_Id   \t Student Id   \t Student Name   \t Grade Points   \t   Grade Status");

			while (rs.next()) {
				Grade grade = new Grade();
				grade.setGid(rs.getInt(1));
				grade.setStdid(rs.getInt(2));
				grade.setStd_name(rs.getString(3));
				grade.setPoints(rs.getDouble(4));
				grade.setStatus(rs.getString(5));
				list.add(grade);
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		return list;
	}

	public static void main(String[] args) {

		ProfessorDaoImpl profDao = new ProfessorDaoImpl();

		List<Student> list = profDao.getStudentData();

		for (Student st : list) {
			System.out.println(st.getId() + "\t\t  " + st.getName() + "\t\t          " + st.getDepartment()
					+ "\t\t           " + st.getUsername() + "\t\t            " + st.getPassword());
		}

		List<Course> course = profDao.getCourseData();
		for (Course c : course) {
			System.out.println(c.getCid() + "\t\t" + c.getName());
		}

		List<Grade> grade = profDao.getGradeData();
		for (Grade g : grade) {
			System.out.println(g.getGid() + "\t\t  " + g.getStdid() + "\t\t    " + g.getStd_name() + "\t\t    "
					+ g.getPoints() + "\t\t   " + g.getStatus());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username: ");
		String username = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();

		profDao.getLoginDetails(username, password);

	}

}