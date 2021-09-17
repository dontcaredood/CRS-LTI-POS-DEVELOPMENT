package com.lt.dao;

import java.util.*;
import java.sql.*;
import com.lt.bean.*;
import com.lt.constants.Constants;
import com.lt.utils.DBUtils;

public class AdminDaoImpl implements AdminDao{

	public HashMap<Integer, String> getLoginDetails() {
		
		Connection con = null;
		String sql = Constants.AdminLogin;
		HashMap<Integer, String> adminDetails = new HashMap<Integer, String>();
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				adminDetails.put(rs.getInt(1),rs.getString(3));
			}

		} catch (SQLException e) {
			System.err.println("Admin Login Error!");
		}

		return adminDetails;
	}

	public List<Student> getStudentDetails() {
		Connection con = null;
		String sql = Constants.AdminGetStudentDetails;
		List<Student> studentDetails = new ArrayList<Student>();
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				s.setStudentId(rs.getInt(1));
				s.setStudentName(rs.getString(2));
				s.setDepartment(rs.getString(3));
				studentDetails.add(s);
			}

		} catch (SQLException e) {
			System.err.println("Admin : Generate Grade Error!");
		}
		return studentDetails;
	}
	
	public ArrayList<Course> showCourses(){
		Connection con = null;
		String sql = Constants.AdminShowCourses;
		ArrayList<Course> courseDetails = new ArrayList<Course>();
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Course g = new Course();
				g.setCourseId(rs.getString(2));
				g.setCourseName(rs.getString(3));
				g.setCourseDescription(rs.getString(4));
				courseDetails.add(g);
			}

		} catch (SQLException e) {
			System.err.println("Admin : Show Courses Error!");
		}
		return courseDetails;	
	}
	
	public ArrayList<Professor> showProfessors(){
		Connection con = null;
		String sql = Constants.AdminShowProfessors;
		ArrayList<Professor> professorDetails = new ArrayList<Professor>();
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Professor prof = new Professor();
				prof.setProfessorId(rs.getInt(1));
				prof.setProfessorName(rs.getString(2));
				prof.setProfessorPassword(rs.getString(3));
				prof.setProfessorDepartment(rs.getString(4));
				professorDetails.add(prof);
			}

		} catch (SQLException e) {
			System.err.println("Admin : Show Professors Error!");
		}
		return professorDetails;	
	}
	public boolean approveStudent(int studentId, String result){
		Connection con = null;
		PreparedStatement ps = null;
		String sql = Constants.AdminApproveStudent;
		boolean flag = false;
		try {
			con = DBUtils.getConnection();
			ps = con.prepareStatement(sql);
	        ps.setString(1,result);
	        ps.setInt(2,studentId);
			int rs = ps.executeUpdate();
			if(rs>0) {flag = true;}
		} catch (SQLException e) {
			System.err.println("Admin : Add Professor Error!");
			e.printStackTrace();
 		}
		return true;
	}
	public boolean addProfessorData(Professor professsor) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = Constants.AdminAddProfessor;
		boolean flag = false;
		try {
			con = DBUtils.getConnection();
			ps = con.prepareStatement(sql);
	        ps.setString(1,professsor.getProfessorName());
	        ps.setString(2,professsor.getProfessorPassword());
	        ps.setString(3,professsor.getProfessorDepartment());
			int rs = ps.executeUpdate();
			if(rs>0) {flag = true;}
		} catch (SQLException e) {
			System.err.println("Admin : Add Professor Error!");
			e.printStackTrace();
 		}
//			finally{
//            try{
//               if(ps!=null)
//                  ps.close();
//            }catch(SQLException se2){
//            	se2.printStackTrace();
//            }
//            try{
//               if(con!=null)
//                  con.close();
//            }catch(SQLException se){
//               se.printStackTrace();
//            }//end finally try
//		}
		return flag;
	}

	public boolean addCourses(Course course) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = Constants.AdminAddCourse;
		boolean flag = false;
		try {
			con = DBUtils.getConnection();
			ps = con.prepareStatement(sql);
	        ps.setString(1,course.getCourseId());
	        ps.setString(2,course.getCourseName());
	        ps.setString(3,course.getCourseDescription());
			int rs = ps.executeUpdate();
			if(rs>0) {flag = true;}
		} catch (SQLException e) {
			System.err.println("Admin : Add Courses Error!");
			e.printStackTrace();
 		}
		return flag;
	}

	public boolean removeCourses(String courseId) {
		Connection con =null;
		PreparedStatement ps = null;
		String sql = Constants.AdminRemoveCourse;
		boolean flag = false;
		try {
			con = DBUtils.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, courseId);
			int rs = ps.executeUpdate();
			if(rs>0) {flag = true;}
		} catch (Exception e) {
			System.err.println("Admin : Remove Course Error!");
			e.printStackTrace();
		}
		return flag;
	}

	public List<GradeCard> getGradeCardDetails() {
		Connection con = null;
		String sql = Constants.AdminGetGradeCard;
		List<GradeCard> gradeDetails = new ArrayList<GradeCard>();
		try {
			con = DBUtils.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GradeCard g = new GradeCard();
				g.setStudentId(rs.getInt(2));
				g.setStudentName(rs.getString(3));
				g.setStudentDepartment(rs.getString(4));
				g.setGradePoints(rs.getFloat(5));
				g.setRemarks(rs.getString(6));
				gradeDetails.add(g);
			}

		} catch (SQLException e) {
			System.err.println("Admin : Generate Grade Error!");
		}

		return gradeDetails;
	}

}
