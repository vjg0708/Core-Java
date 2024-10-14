package com.training.package1;

public class Account {
	
	
	private long accNumber ;
	private double balance;
	private PersonUser accHolder;
	
	public Account(long accNumber, double balance, PersonUser accHolder) {
		super();
		this.accNumber = accNumber;
		this.balance = balance;
		this.accHolder = accHolder;
	}
	public long getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(long accNumber) {
		this.accNumber = accNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public PersonUser getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(PersonUser accHolder) {
		this.accHolder = accHolder;
	}
	
	public static long generateAccNumber() {
		
		long number = (long)(Math.random()*1000000000000l);
		return number;
	}
	
	public void depositAmount(double amount) {
		
		double temp = balance;
		balance += amount;
		if((balance-temp)>=500) {
			
			System.out.println("amount deposited and maintaining sufficient balance");
		}
		
		else {
			System.out.println("amount deposited but maintain sufficient min balance of 500");
		}
	}
	
	public void withDrawAmount(double amount) {
		
		if((balance-amount)>500) {
			
			balance -=amount;
			
			System.out.println("amount withdrawn successfully with current balance : " + this.balance);
		}
		
		else {
			System.out.println("Insufficient balance");
		}
	}
	@Override
	public String toString() {
		return "Account [accNumber=" + accNumber + ", balance=" + balance + ", accHolder=" + accHolder.getName() + ", " + accHolder.getAge() +"]";
	}
	
	
	

}
