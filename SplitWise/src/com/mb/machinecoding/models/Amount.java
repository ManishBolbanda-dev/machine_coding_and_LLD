package com.mb.machinecoding.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Amount {
	private Currency currency;
	private Double amountValue;
	public Amount() {
		this.currency = Currency.USD;
		this.amountValue = 0d;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Double getAmountValue() {
		return amountValue;
	}
	public void setAmountValue(Double amountValue) {
		this.amountValue = amountValue;
	}
	public void updateAmountVaue(Double amountValue2) {
		this.amountValue += amountValue2;
	}
	
	
}
