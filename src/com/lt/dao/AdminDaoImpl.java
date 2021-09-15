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
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addProfessorData(Professor professsor) {
		Connection con = null;
		PreparedStatement ps = null;
		List<Student> list = new ArrayList<Student>();
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
		List<Student> list = new ArrayList<Student>();
		String sql = Constants.AdminAddProfessor;
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
			System.err.println("Admin : Add Professor Error!");
			e.printStackTrace();
 		}
		return flag;
	}

	public boolean removeCourses(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<GradeCard> getGradeCardDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
