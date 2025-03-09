package com.mb.machinecoding.builder;

import java.util.ArrayList;
import java.util.List;

import com.mb.machinecoding.models.AddExpenseRequest;
import com.mb.machinecoding.models.Amount;
import com.mb.machinecoding.models.Currency;
import com.mb.machinecoding.models.Expense;
import com.mb.machinecoding.models.User;
import com.mb.machinecoding.models.UserBalance;

public class EqualSplitBuilder {
	public static Expense build(AddExpenseRequest addExpenseRequest) {
		Expense expense = new Expense();
		Amount totalAmount = new Amount(Currency.USD, addExpenseRequest.getTotalAmount()); 
		double amountPerUser = totalAmount.getAmountValue()/addExpenseRequest.getUsers().size();
		expense.setPaidUserId(addExpenseRequest.getPayedUserId());
		expense.setTotalAmount(totalAmount);
		expense.setGroupId(addExpenseRequest.getGroupId());
		
		List<UserBalance> allUserBalance = new ArrayList<>();
		for(User user: addExpenseRequest.getUsers()) {
			UserBalance usrBalance ;
			if(user.getId() == expense.getPaidUserId()) {
				// paid - amountperUser
				usrBalance = new UserBalance(user, new Amount(Currency.USD, addExpenseRequest.getTotalAmount() - amountPerUser));
			}else {
				usrBalance = new UserBalance(user, new Amount(Currency.USD, -amountPerUser));
			}
			allUserBalance.add(usrBalance);
		}
		expense.setAllUserBalances(allUserBalance);
		return expense;
	}
}
