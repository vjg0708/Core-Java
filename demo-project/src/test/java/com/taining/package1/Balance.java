package com.taining.package1;

public class Balance {
	
	String bankName;
	double balance;
	
	public Balance(String bankName, double balance) {
		
		this.bankName = bankName;
		this.balance = balance;
	}
	
	public void show() {
		
		if(balance<0) {
			
			System.out.println("Bank Of : " + bankName + "has insufficient "
					+ "balance of : " 
					 + balance);
		}
		else {
			System.out.println("Bank : " + bankName + " has sufficient "
					+ "balance of : " 
					 + "$" + balance);}
	}
}
