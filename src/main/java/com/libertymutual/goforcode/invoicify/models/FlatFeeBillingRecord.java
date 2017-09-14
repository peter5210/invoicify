package com.libertymutual.goforcode.invoicify.models;

public class FlatFeeBillingRecord extends BillingRecord {

	public double amount;
	
	@Override
	public double getTotal() {
		return amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
