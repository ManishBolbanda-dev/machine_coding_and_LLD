package com.mb.machinecoding.datastore;

import java.util.List;

import com.mb.machinecoding.models.Expense;

public interface ExpenseStore {
	void addExpense(Expense expense);
	Expense getExpenseById(String id);
	List<Expense> getExpenseByGroupId(int userId);
}
