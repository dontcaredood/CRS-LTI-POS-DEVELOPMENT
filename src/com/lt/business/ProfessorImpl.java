package com.lt.business;

import com.lt.bean.Grade;
import com.lt.dao.ProfessorDaoImpl;

public class ProfessorImpl implements ProfessorInterface {

	ProfessorDaoImpl profDao=new ProfessorDaoImpl();
	
	
	@Override
	public void viewCourse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGrade(Grade grade) {
		// TODO Auto-generated method stub
	}

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
	profDao.getLoginDetails(username, password);
	}

}
