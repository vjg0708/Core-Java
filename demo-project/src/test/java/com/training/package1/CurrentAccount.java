package com.training.package1;

public class CurrentAccount extends Account{
	
	private final long overdraftLimit = 100000;

	public CurrentAccount(long accNumber, double balance, PersonUser accHolder) {
		super(accNumber, balance, accHolder);
		// TODO Auto-generated constructor stub
		System.out.println("In class current account");
	}

	public long getOverdraftLimit() {
		return overdraftLimit;
	}


	public void withDrawAmount(double amount) {
		// TODO Auto-generated method stub
		
		double totalODWithdrawalLimit = super.getBalance() + overdraftLimit;
		
		if(amount <= totalODWithdrawalLimit) {
			
			System.out.println("the amount is within overfraft limit"+"\n"+
			"Withdrawal is accepted");
			super.withDrawAmount(amount);
		}
		
		else {
			System.out.println("the amount exceeded overdraft limit, withdrawal is denied");
		}
	}
	
	
	


}
