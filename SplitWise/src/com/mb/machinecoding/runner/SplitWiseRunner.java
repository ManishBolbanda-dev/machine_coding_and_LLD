package com.mb.machinecoding.runner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mb.machinecoding.models.AddExpenseRequest;
import com.mb.machinecoding.models.Amount;
import com.mb.machinecoding.models.Currency;
import com.mb.machinecoding.models.Expense;
import com.mb.machinecoding.models.ExpenseSplitType;
import com.mb.machinecoding.models.Group;
import com.mb.machinecoding.models.User;
import com.mb.machinecoding.models.UserBalance;
import com.mb.machinecoding.service.ExpenseService;
import com.mb.machinecoding.service.GroupService;

public class SplitWiseRunner {
	private static GroupService groupService = new GroupService();
	private static ExpenseService expenseService = new ExpenseService();
	
	public static void main(String[] args) {
		// add static users
		// add group
		int idx = 1;
		User u1 = new User(1, "John");
		User u2 = new User(2, "Sam");
		User u3 = new User(3, "Daniel");
		User u4 = new User(4, "Mohan");
		
		int group_id = 223;
//		Group group1 = new Group(223, "dhamal_group", List.of(u1, u2, u3, u4));
		idx=1;
//		expenseService.addExpense(new Expense(1, "restro", "", 1, new Amount(Currency.USD, 2000), 2, List.of(u1, u2, u3, u4)));
		
		// add expense from termial - take input and Build AddExpenseRequest
		
		AddExpenseRequest addExpenseRequest = new AddExpenseRequest(2, 2000d, List.of(u1,  u2, u3, u4), ExpenseSplitType.EQUAL , null, group_id);
		Expense expense1 = expenseService.addExpense(addExpenseRequest);
		
		addExpenseRequest = new AddExpenseRequest(4, 4000d, List.of(u1,  u2, u3, u4), ExpenseSplitType.EQUAL , null, group_id);
		Expense expense2 = expenseService.addExpense(addExpenseRequest);
		
		addExpenseRequest = new AddExpenseRequest(3, 800d, List.of(u1,  u2, u3, u4), ExpenseSplitType.EQUAL , null, group_id);
		Expense expense3 = expenseService.addExpense(addExpenseRequest);
		
		Map<User, List<UserBalance>> balanceGraph = groupService.getPaymentGraphForGroup(group_id, 4);
		for(User user: balanceGraph.keySet()) {
			for(UserBalance usb : balanceGraph.get(user)) {
				System.out.println(" --- "+user.getName()+" Owes AMount of "+usb.getAmount().getAmountValue()+" to "+usb.getUser().getName());
			}
		}
		
//		this
		
		
	}
	

}
