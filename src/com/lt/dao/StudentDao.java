package com.lt.dao;

import java.util.*;

import com.lt.bean.*;
import com.lt.exceptions.StudentNotRegisteredException;

public interface StudentDao {
	
	public int addStudent(Student student) throws StudentNotRegisteredException;
	

	public int getStudentId(String userId);
	
	
	public boolean isApproved(int studentId);
}
