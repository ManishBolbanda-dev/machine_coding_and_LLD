package com.mb.machinecoding.builder;

import com.mb.machinecoding.models.AddExpenseRequest;
import com.mb.machinecoding.models.Expense;
import com.mb.machinecoding.models.ExpenseSplitType;

public class ExpenseBuilder {
	public Expense build(AddExpenseRequest addExpenseRequest) {
		if(addExpenseRequest.getSplitType() == ExpenseSplitType.EQUAL) {
			return EqualSplitBuilder.build(addExpenseRequest);
		}else if(addExpenseRequest.getSplitType() == ExpenseSplitType.EXACT) {
			
		}else if(addExpenseRequest.getSplitType() == ExpenseSplitType.PERCENT) {
			
		}
		throw new RuntimeException("Invalid Expense Type");
	}
}
