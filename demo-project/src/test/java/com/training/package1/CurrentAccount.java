package com.training.package1;

public class CurrentAccount extends Account{
	
	private final long overdraftLimit = 100000;
	
	private final long minBalance = 500;

	public long getMinBalance() {
		return minBalance;
	}

	public CurrentAccount(long accNumber, double balance, PersonUser accHolder) {
		super(accNumber, balance, accHolder);
		// TODO Auto-generated constructor stub
		System.out.println("In class current account");
	}

	public long getOverdraftLimit() {
		return overdraftLimit;
	}

	@Override
	public void withDrawAmount(double amount) {
		// TODO Auto-generated method stub
		
		double withdrawalLimit = super.getBalance() + overdraftLimit;
		
		double accessibleFunds = withdrawalLimit - this.getMinBalance();
		
		System.out.println("Total OD withdrawal limit is : " + withdrawalLimit);
		System.out.println("Current balance : " + super.getBalance());
		
		if(amount <= accessibleFunds) {
			
				System.out.println("Withdrawal is accepted upto : " + accessibleFunds);
				accessibleFunds -= amount;
				System.out.println("Current accessible funds : " + accessibleFunds);
				super.setBalance(accessibleFunds-this.getBalance());
				
				System.out.println("Remaining balance : " + super.getBalance());
				
				if(super.getBalance()>=500) {
					
					System.out.println("current balance within limit");
				}
				else {
					System.out.println("current balance is low, maintain minimum balance limit");
				}
		}
		else {
			System.out.println("the amount exceeded overdraft limit, withdrawal is denied");
		}
	}
	
	
	


}
