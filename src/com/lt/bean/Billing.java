package com.lt.bean;

public class Billing {
	private int billNumber;
	private String description;
	private boolean paymentStatus;
	private float billAmount;
	
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
