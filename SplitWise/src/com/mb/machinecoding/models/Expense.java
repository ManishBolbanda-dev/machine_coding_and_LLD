package com.mb.machinecoding.models;

import java.util.List;

public class Expense {
	private int expenseId; // auto generated
	
	private String description;
	private String imageUrl;
	private int groupId;
//	private boolean isSettled;
	private Amount totalAmount;
	private Integer paidUserId;
	private List<UserBalance> allUserBalances;
	
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public Amount getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Amount totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Integer getPaidUserId() {
		return paidUserId;
	}
	public void setPaidUserId(Integer paidUserId) {
		this.paidUserId = paidUserId;
	}
	public List<UserBalance> getAllUserBalances() {
		return allUserBalances;
	}
	public void setAllUserBalances(List<UserBalance> allUserBalances) {
		this.allUserBalances = allUserBalances;
	}
	public Expense() {}
	
	public Expense(int expenseId, String description, String imageUrl, int groupId, Amount totalAmount,
			Integer paidUserId, List<UserBalance> allUserBalances) {
		super();
		this.expenseId = expenseId;
		this.description = description;
		this.imageUrl = imageUrl;
		this.groupId = groupId;
		this.totalAmount = totalAmount;
		this.paidUserId = paidUserId;
		this.allUserBalances = allUserBalances;
	}
	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", groupId=" + groupId + ", totalAmount=" + totalAmount + ", paidUserId=" + paidUserId
				+ ", allUserBalances=" + allUserBalances + "]";
	}
	
	
	
}
