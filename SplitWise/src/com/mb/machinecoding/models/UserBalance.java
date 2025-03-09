package com.mb.machinecoding.models;

public class UserBalance {
	private User user;
	private Amount amount;
	
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserBalance(User user, Amount balance) {
		super();
		this.user = user;
		this.amount = balance;
	}
	public UserBalance clone() {
		return new UserBalance(this.user, this.amount);
	}
	@Override
	public String toString() {
		return "UserBalance [userId=" + user.getId() + ", amount=" + amount.getAmountValue() + "]";
	}
	
}
