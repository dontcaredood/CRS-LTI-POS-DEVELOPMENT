package com.lt.business;

public interface PaymentNotificationInterface {
	public boolean paymentStatus();
	public String paymentRemainder();
	public String sendNotification();
	public String notificationMessage();
}
