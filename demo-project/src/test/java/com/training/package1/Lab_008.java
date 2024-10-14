package com.training.package1;

public class Lab_008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account accForSmith = new Account(Account.generateAccNumber(),
				2000, new PersonUser("Smith", 23));
		
		Account accForkathy = new Account(Account.generateAccNumber(), 3000,
				new PersonUser("Kathy", 30));
		
		accForSmith.depositAmount(2000);
		System.out.println("Updated balance for smith : " + accForSmith.getBalance());
		
		accForkathy.withDrawAmount(2000);
		System.out.println("Current balance for Kathy : "+ accForkathy.getBalance());
		
		System.out.println(accForSmith.toString());
		System.out.println(accForkathy.toString());
		

	}

}
