package com.lt.business;
import com.lt.dao.*;
import com.lt.exceptions.UserNotFoundException;

public class UserInterfaceImpl implements UserInterface{
	UserDaoImpl UserDaoImpl = new UserDaoImpl();
	
	public boolean updatePassword(String userID,String newPassword) {
		return UserDaoImpl.updatePassword(userID, newPassword);
	}


	public boolean verifyCredentials(String userID, String password) throws UserNotFoundException {
		//DAO class
		try
		{
			return UserDaoImpl.verifyCredentials(userID, password);		
		}
		finally
		{
			
		}
	}
	
	
	public String getRole(String userId) {
		return UserDaoImpl.getRole(userId);
	}


	



}
