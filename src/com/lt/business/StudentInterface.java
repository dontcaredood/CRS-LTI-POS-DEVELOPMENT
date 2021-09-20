package com.lt.business;

import com.lt.bean.Student;
import com.lt.constants.Gender;
import com.lt.exceptions.StudentNotRegisteredException;

public interface StudentInterface {
	
	
	public int register(Student student) throws StudentNotRegisteredException; 
	
	public int getStudentId(String userId);
	
	
    public boolean isApproved(int studentId);
}
