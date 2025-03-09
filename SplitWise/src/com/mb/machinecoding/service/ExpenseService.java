package com.mb.machinecoding.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.mb.machinecoding.builder.ExpenseBuilder;
import com.mb.machinecoding.models.AddExpenseRequest;
import com.mb.machinecoding.models.Amount;
import com.mb.machinecoding.models.Expense;
import com.mb.machinecoding.models.ExpenseSplitType;
import com.mb.machinecoding.models.User;
import com.mb.machinecoding.models.UserBalance;

public class ExpenseService {
	
	ExpenseBuilder expenseBuilder = new ExpenseBuilder();
	
	static List<Expense> allExpenses = new ArrayList<>(); // this can be moved to a DataStore class
	
	public Expense addExpense(AddExpenseRequest expenseReq) {
		System.out.println("Add req received: "+expenseReq);
		
		Expense expense = expenseBuilder.build(expenseReq);
		this.allExpenses.add(expense);
		System.out.println("Expense added succesfully: Payed By"+expense.getPaidUserId()+" total expense: "+this.allExpenses.size());
		return expense;
//		expenseDao.save(expense);
	}
	
	List<Expense> getAllGroupeExpenses(int groupId){
		return this.allExpenses; //.stream().filter(exp -> exp.getGroupId() == groupId).toList();
	}
	
	public void addExpenseInDataStore(Expense expense) {
		this.allExpenses.add(expense);
	}
	public Map<User, List<UserBalance>> prepareGraphFromUserBalances(List<UserBalance> groupUserBalances) {
		// Main Algorithm Logic: to build edges or transation that shows balances between users
		
		// two PQs, +ve values and -ve values.
		PriorityQueue<UserBalance> positiveQue = new PriorityQueue<>(Comparator.comparingDouble(usb -> -usb.getAmount().getAmountValue()));
		PriorityQueue<UserBalance> negetiveQue = new PriorityQueue<>(Comparator.comparingDouble(usb -> usb.getAmount().getAmountValue()));
		
		Map<User, List<UserBalance>>  graph = new HashMap<>();
		
		for(UserBalance usb : groupUserBalances) {
			if(usb.getAmount().getAmountValue() > 0) {
				positiveQue.add(usb);
			}else {
				negetiveQue.add(usb);
			}
		}
		
		while(!positiveQue.isEmpty() && !negetiveQue.isEmpty()) {
			UserBalance positiveMax = positiveQue.remove();
			UserBalance negMax = negetiveQue.remove();
			Double absNegVal = Math.abs(negMax.getAmount().getAmountValue());
			
			// 100,  -99 | 100, -110
			Double payableAmount = Math.min(positiveMax.getAmount().getAmountValue(), absNegVal);
			graph.putIfAbsent(negMax.getUser(), new ArrayList<>());
			graph.getOrDefault(negMax.getUser(), new ArrayList<>()).add(new UserBalance(positiveMax.getUser(), new Amount(negMax.getAmount().getCurrency(), payableAmount)));
			
			if(positiveMax.getAmount().getAmountValue() > absNegVal) {
				positiveMax.getAmount().updateAmountVaue(-payableAmount); // reducing positive number
				positiveQue.add(positiveMax);
			}else if(positiveMax.getAmount().getAmountValue() < absNegVal) {
				negMax.getAmount().updateAmountVaue(payableAmount);
				negetiveQue.add(negMax);
			}else {
				// both elements will be removed, no ones is getting into que
			}
		}
		
		return graph;
	}
}
