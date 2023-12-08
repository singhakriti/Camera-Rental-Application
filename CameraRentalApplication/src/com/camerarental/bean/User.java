package com.camerarental.bean;

public class User {
	private String userId;
	private float walletBalance;
	public User(String userId, float walletBalance) {
		this.userId = userId;
		this.walletBalance = walletBalance;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public float getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(float walletBalance) {
		this.walletBalance = walletBalance;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", walletBalance=" + walletBalance + "]";
	}

}
