package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.bean.Student;
import com.lt.contants.Constants;
import com.lt.utils.DBUtils;

public class ProfessorDaoImpl implements ProfessorDao {

	private static ProfessorDaoImpl professorDao=null;
	private static Logger logger=Logger.getLogger(ProfessorDaoImpl.class);
	
	//private Constructor for ProfessorDaoImpl
	private ProfessorDaoImpl()
	{
		logger.info("ProfessorDaoImpl Instance created");
	}
	
	public List<Student> getStudentData() {
		// TODO Auto-generated method stub
		Connection con = null;

		List<Student> list = new ArrayList<Student>();

		String sql = Constants.PROFESSORgetStudentData;
		try {
			con = DBUtils.getConnection();

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			logger.info("Show Student Data Below");
			logger.info("\nStudennt Id   \t Student Name   \t Student Department   \t    Student Password");

			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt(1));
				student.setStudentName(rs.getString(2));
				student.setDepartment(rs.getString(3));
				student.setPassword(rs.getString(4));
				list.add(student);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Professor : Error In getStudentData");
			e.printStackTrace();
		}

		return list;
	}

	public List<Course> getCourseData() {
		// TODO Auto-generated method stub

		Connection con = null;

		List<Course> list = new ArrayList<Course>();

		String sql = Constants.PROFESSORgetCourseData;
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			logger.info("Show Courses Data Below");
			logger.info("\nSR No. \t Course Id   \t Course Name \tCourse Description \t Course Amount \t Professor Name");

			while (rs.next()) {
				Course course = new Course();
				course.setSrno(rs.getInt(1));
				course.setCourseId(rs.getString(2));
				course.setCourseName(rs.getString(3));
				course.setCourseDescription(rs.getString(4));
				course.setCourseAmount(rs.getInt(5));
				course.setProfessorName(rs.getString(6));
				list.add(course);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Professor : Error In getCourseData");
		}

		return list;
	}

	public void getLoginDetails(int userId, String password)  {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = Constants.PROFESSORgetLoginDetails;
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			
				if (userId == rs.getInt(1) && password.equals(rs.getString(2))) {
					logger.info("You have Login Successfully");
				}

			} else {
				logger.warn("Login Failed Try Again!!!");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Professor : Error In getLoginDetails");
			
		} 
		

	}

	public void addGrade(Grade grade) {
		// TODO Auto-generated method stub
		

		Connection con = null;
		String sql = Constants.PROFESSORaddGrade;
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, grade.getGradeStatus());
			ps.setDouble(2, grade.getGradePoints());
			ps.setInt(3, grade.getStudentId());
			ps.execute();
			logger.info("Professor Added Grade Success");

		} catch (SQLException e) {
			logger.error("Professor : Error In AddGrade");
			e.printStackTrace();
		}

	}

	public List<Grade> getGradeData() {
		// TODO Auto-generated method stub
		Connection con = null;

		List<Grade> list = new ArrayList<Grade>();

		String sql = Constants.PROFESSORgetGradeData;
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			logger.info("Show Grade Data Below");
			logger.info("\nGrade_Id   \t Student Id   \t Student Name   \t Grade Points   \t   Grade Status");

			while (rs.next()) {
				Grade grade = new Grade();
				grade.setGradeId(rs.getInt(1));
				grade.setStudentId(rs.getInt(2));
				grade.setStudentName(rs.getString(3));
				grade.setGradePoints(rs.getDouble(4));
				grade.setGradeStatus(rs.getString(5));
				list.add(grade);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			logger.error("Professor : Error In getGradeData");
		}

		return list;
	}

	public static void main(String[] args)  {

		ProfessorDaoImpl profDao = ProfessorDaoImpl.getInstance();
		
		List<Student> list = profDao.getStudentData();

		for (Student st : list) {
			logger.info(st.getStudentId() + "\t\t  " + st.getStudentName() + "\t\t          "
					+ st.getDepartment() + "\t\t           " + st.getPassword());
		}

		List<Course> course = profDao.getCourseData();
		for (Course c : course) {
			logger.info(c.getSrno() + "\t\t" + c.getCourseId() + "\t\t" + c.getCourseName() + "\t\t"
					+ c.getCourseDescription()+"\t\t"+c.getCourseAmount()+"\t\t"+c.getProfessorName());
		}
		Scanner sc = new Scanner(System.in);

		logger.info("Enter Username: ");
		int username = sc.nextInt();
		logger.info("Enter Password: ");
		String password = sc.next();
		profDao.getLoginDetails(username, password);

		List<Grade> grade = profDao.getGradeData();
		for (Grade g : grade) {
			logger.info(g.getGradeId() + "\t\t  " + g.getStudentId() + "\t\t    " + g.getStudentName()
					+ "\t\t    " + g.getGradePoints() + "\t\t           " + g.getGradeStatus());
		}

		Grade grade1 = new Grade();
		logger.info("Enter Grade Status: ");
		String gradeStatus = sc.next();
		logger.info("Enter Grade Points: ");
		double gradePoints = sc.nextDouble();
		logger.info("Enter Student Id: ");
		int stdid = sc.nextInt();

		grade1.setGradeStatus(gradeStatus);
		grade1.setGradePoints(gradePoints);
		grade1.setStudentId(stdid);

		profDao.addGrade(grade1);

	}

	public static ProfessorDaoImpl getInstance()
	{
		if(professorDao==null)
		{
			synchronized (ProfessorDaoImpl.class) {
				professorDao=new ProfessorDaoImpl();				
			}
		}
		return professorDao;
	}
	
}