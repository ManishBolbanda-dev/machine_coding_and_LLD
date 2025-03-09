package com.mb.machinecoding.models;

import java.util.List;

public class AddExpenseRequest {
	private int payedUserId; 
	private Double totalAmount;
	private List<User> users;
	private ExpenseSplitType splitType;
	private List<Integer> splitValues;
	private int groupId;
	
	public int getPayedUserId() {
		return payedUserId;
	}
	public void setPayedUserId(int payedUserId) {
		this.payedUserId = payedUserId;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public ExpenseSplitType getSplitType() {
		return splitType;
	}
	public void setSplitType(ExpenseSplitType splitType) {
		this.splitType = splitType;
	}
	public List<Integer> getSplitValues() {
		return splitValues;
	}
	public void setSplitValues(List<Integer> splitValues) {
		this.splitValues = splitValues;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	public AddExpenseRequest(int payedUserId, Double totalAmount, List<User> users, ExpenseSplitType splitType,
			List<Integer> splitValues, int groupId) {
		this.payedUserId = payedUserId;
		this.totalAmount = totalAmount;
		this.users = users;
		this.splitType = splitType;
		this.splitValues = splitValues;
		this.groupId = groupId;
	}
	public AddExpenseRequest() {
	}
	@Override
	public String toString() {
		return "AddExpenseRequest [payedUserId=" + payedUserId + ", totalAmount=" + totalAmount + ", users=" + users
				+ ", splitType=" + splitType + ", splitValues=" + splitValues + ", groupId=" + groupId + "]";
	}
	
	
}
