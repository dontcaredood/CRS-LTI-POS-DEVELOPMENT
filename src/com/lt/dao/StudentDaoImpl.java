package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.contants.Constants;
import com.lt.utils.DBUtils;

public class StudentDaoImpl implements StudentDao {

	private static StudentDaoImpl studentDao=null;
	private static Logger logger = Logger.getLogger(StudentDaoImpl.class);

	//private Constructor for StudentDaoImp
	private  StudentDaoImpl() {
		// TODO Auto-generated constructor stub
	logger.info("StudentDaoImpl Instance Created");
	}
	
	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = Constants.STUDENTaddCourse;
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, course.getCourseId());
			ps.setString(2, course.getCourseName());
			ps.setString(3, course.getCourseDescription());
			ps.execute();
			logger.info("Course has been added");
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Student : Error In AddCourse method");
			e.printStackTrace();
		}

	}

	@Override
	public void dropCourse(String courseName) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = Constants.STUDENTdropCourse;
		String sql2 = Constants.STUDENTCourseName;
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, courseName);

			PreparedStatement ps2 = con.prepareStatement(sql2);
			ResultSet rs = ps2.executeQuery();

			boolean isCheck = false;

			while (rs.next()) {
				if (rs.getString(1).equals(courseName)) {
					isCheck = true;
				}
			}
			if (isCheck) {
				ps.execute();
				logger.info("Course has been Drop");
			} else {
				logger.warn("Course Name is not Found in Courses");
			}

		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Student : Error In dropCourse method");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		StudentDaoImpl student = StudentDaoImpl.getInstance();
		Scanner sc = new Scanner(System.in);

		logger.info("Enter Course Id: ");
		String cid = sc.next();
		logger.info("Enter Course Name: ");
		String cname = sc.next();
		logger.info("Enter Course Description: ");
		String cdescription = sc.next();
		Course course = new Course();
		course.setCourseId(cid);
		course.setCourseName(cname);
		course.setCourseDescription(cdescription);

		student.addCourse(course);

		Scanner sc2 = new Scanner(System.in);

		logger.info("Enter Course Name To Drop Course: ");
		String coursename = sc2.next();

		student.dropCourse(coursename);

	}
	
	
	public static StudentDaoImpl getInstance()
	{
		if(studentDao==null)
		{
			synchronized (StudentDaoImpl.class) {
				studentDao=new StudentDaoImpl();
			}
		}
	return studentDao;
	}
	
}
