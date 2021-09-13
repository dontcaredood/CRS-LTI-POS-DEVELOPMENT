package com.lt.bean;

import java.util.Date;

public class Billing {
	
	private int billNumber;
	private Date billDate;
	private String description;
	private boolean paymentStatus;
	private float billAmount;
	private String paymentType;
	
	public final Date getBillDate() {
		return billDate;
	}
	public final void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public final String getPaymentType() {
		return paymentType;
	}
	public final void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public int getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}
	
}
