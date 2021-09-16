package com.lt.business;

import com.lt.bean.Grade;

public interface ProfessorInterface {

	public void viewCourse();
	public void addGrade(Grade grade);
	public void login(int username,String password);
	
	
}
