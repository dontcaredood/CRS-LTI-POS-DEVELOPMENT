package com.lt.business;

import java.sql.SQLException;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.lt.constants.*;
import com.lt.dao.NotificationDaoImpl;

/**
 * 
 * @author JEDI-03
 * This method implements all the method related to the notification system
 */
public class NotificationOperation implements NotificationInterface {

	private static volatile NotificationOperation instance=null;
	NotificationDaoImpl notificationDaoInterface= new NotificationDaoImpl();
	private static Logger logger = Logger.getLogger(NotificationOperation.class);
	
	/**
	 * Method to send notification
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @param modeOfPayment: payment mode used
	 * @return notification id for the record added in the database
	 */
	@Override
	public int sendNotification(NotificationType type, int studentId,ModeOfPayment modeOfPayment,String paymentMethod,double amount) {
		int notificationId=0;
		try
		{
			notificationId=notificationDaoInterface.sendNotification(type, studentId,modeOfPayment,paymentMethod,amount);
			
		}
		catch(SQLException ex)
		{
			logger.error("Error occured "+ex.getMessage());
		}
		return notificationId;
	}

	/**
	 * Method to return UUID for a transaction
	 * @param notificationId: notification id added in the database
	 * @return transaction id of the payment
	 */
	@Override
	public UUID getReferenceId(int notificationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
