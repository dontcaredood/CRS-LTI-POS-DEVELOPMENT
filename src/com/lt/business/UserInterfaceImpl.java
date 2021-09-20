package com.lt.business;

import com.lt.bean.User;
import com.lt.dao.UserDaoImpl;
import com.lt.exception.UserNotFoundException;


public class UserInterfaceImpl implements UserInterface{
	
	UserDaoImpl userDaoImpl = UserDaoImpl.getInstance();
	
	public boolean updatePassword(String userID,String newPassword) {
		return userDaoImpl.updatePassword(userID, newPassword);
	}


	public boolean verifyCredentials(String userID, String password) throws UserNotFoundException {
		//DAO class
		try
		{
			return userDaoImpl.verifyCredentials(userID, password);		
		}
		finally
		{
			
		}
	}
	
	
	public String getRole(String userId) {
		return userDaoImpl.getRole(userId);
	}


	



}