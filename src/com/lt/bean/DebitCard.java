package com.lt.bean;

import java.util.Date;

public class DebitCard {
	private String transactionId;
	private String cardDetails;
	private Date transactionDate;
	public final String getTransactionId() {
		return transactionId;
	}
	public final void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public final String getCardDetails() {
		return cardDetails;
	}
	public final void setCardDetails(String cardDetails) {
		this.cardDetails = cardDetails;
	}
	public final Date getTransactionDate() {
		return transactionDate;
	}
	public final void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}
