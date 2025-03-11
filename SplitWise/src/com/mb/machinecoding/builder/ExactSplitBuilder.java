package com.mb.machinecoding.builder;

import java.util.ArrayList;
import java.util.List;

import com.mb.machinecoding.exception.InvalidExpenseSplitException;
import com.mb.machinecoding.models.AddExpenseRequest;
import com.mb.machinecoding.models.Amount;
import com.mb.machinecoding.models.Currency;
import com.mb.machinecoding.models.Expense;
import com.mb.machinecoding.models.User;
import com.mb.machinecoding.models.UserBalance;

public class ExactSplitBuilder {
	public static Expense build(AddExpenseRequest addExpenseRequest) {
		Expense expense = new Expense();
		Amount totalAmount = new Amount(Currency.USD, addExpenseRequest.getTotalAmount()); 
		expense.setPaidUserId(addExpenseRequest.getPayedUserId());
		expense.setTotalAmount(totalAmount);
		expense.setGroupId(addExpenseRequest.getGroupId());
		
		int expSum = 0;
		for(int exp : addExpenseRequest.getSplitValues())
			expSum += exp;
		if(totalAmount.getAmountValue() != (double) expSum) {
			throw new InvalidExpenseSplitException("Total count doesnt match with expense Amount");
		}
		List<UserBalance> allUserBalance = new ArrayList<>();
		for(int idx=0; idx<addExpenseRequest.getUsers().size(); idx++) {
			User user = addExpenseRequest.getUsers().get(idx);
			double amountPerUser = (double) addExpenseRequest.getSplitValues().get(idx);
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
