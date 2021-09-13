package com.lt.bean;

public class OnlinePayment {
	private String transactionId;
	private String onlineBanking;
	private String upiLink;
	public final String getTransactionId() {
		return transactionId;
	}
	public final void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public final String getOnlineBanking() {
		return onlineBanking;
	}
	public final void setOnlineBanking(String onlineBanking) {
		this.onlineBanking = onlineBanking;
	}
	public final String getUpiLink() {
		return upiLink;
	}
	public final void setUpiLink(String upiLink) {
		this.upiLink = upiLink;
	}
	
	
}
