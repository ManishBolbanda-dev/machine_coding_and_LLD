package com.mb.machinecoding.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mb.machinecoding.models.Expense;
import com.mb.machinecoding.models.User;
import com.mb.machinecoding.models.UserBalance;

public class GroupService {
	private ExpenseService expenseService = new ExpenseService();
	
	private Map<Integer, List<Expense>> grouIdToListOfExpenses = new HashMap<>();
	
//	public void loadcache() {
//		expenseService.getAllGroupeExpenses()
//		.forEach(exp -> grouIdToListOfExpenses.getOrDefault(exp.getGroupId(), new ArrayList<>()).add(exp));
//	}

	public Map<User, List<UserBalance>> getPaymentGraphForGroup(int groupId, int userId) {
		System.out.println("Fetching Payment Graph for group");
		List<UserBalance> groupUserBalances = this.getGroupUserBalces(groupId, userId);
		System.out.println("aggretgated user balance size: "+groupUserBalances.size());
		// prepare Graph
		return expenseService.prepareGraphFromUserBalances(groupUserBalances);
	}
	public List<UserBalance> getGroupUserBalces(int groupId, int userId) {
		// consolidate expense for a group
		if(!isUserPartOfGroup(userId)) {
			throw new UnsupportedOperationException("User is UnAuthorised.");
		}
		Map<Integer, UserBalance> userIdToUserBalMap = new HashMap<>();
		
//		grouIdToListOfExpenses.getOrDefault(groupId, new ArrayList<>())
		System.out.println("expense size fetched from systerm is: "+expenseService.getAllGroupeExpenses(groupId).size());
		expenseService.getAllGroupeExpenses(groupId)
		.forEach(exp -> exp.getAllUserBalances().forEach(userBal -> {
			if(userIdToUserBalMap.get(userBal.getUser().getId()) == null) {
				userIdToUserBalMap.put(userBal.getUser().getId(), userBal.clone());
			}else {
				userIdToUserBalMap.get(userBal.getUser().getId()).getAmount().updateAmountVaue(userBal.getAmount().getAmountValue());
			}
		}));
		
		System.out.println("all user balances: "+userIdToUserBalMap.values());
		return userIdToUserBalMap.values().stream().toList();
	}

	private boolean isUserPartOfGroup(int userId) {
		// TODO pull all users of group and check this userid exist
		return true;
	}
	
}
