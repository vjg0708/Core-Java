package com.training.package1;

public class SavingsAccount extends Account{
	
	
	private final double minbalance = 500;

	public double getMinbalance() {
		return minbalance;
	}


	public SavingsAccount(long accNumber, double balance, PersonUser accHolder) {
		super(accNumber, balance, accHolder);
		// TODO Auto-generated constructor stub
		
		System.out.println("In class Savings account");
	}

	@Override
	public void withDrawAmount(double amount) {
		
		double getBalance = super.getBalance();
		// TODO Auto-generated method stub
		if(getBalance - amount > minbalance) {
			
			getBalance -= amount;
			
			super.setBalance(getBalance);
			
			System.out.println("Account balance After withdrawel is : " + super.getBalance());
			
		}
		else {
			
			System.out.println("Account has insufficient balance");
		}
	}
	
	
	
	
}
