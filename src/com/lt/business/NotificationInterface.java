package com.lt.business;

import java.util.UUID;

import com.lt.constants.*;

public interface NotificationInterface {
	
	public int sendNotification(NotificationType type,int studentId,ModeOfPayment modeOfPayment,String paymentMethod,double amount);
	
	public UUID getReferenceId(int notificationId); 
}
