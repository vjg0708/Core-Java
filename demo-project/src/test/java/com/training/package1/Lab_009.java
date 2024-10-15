package com.training.package1;

public class Lab_009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SavingsAccount accForSmith = new SavingsAccount(Account.generateAccNumber(),
				25000, new PersonUser("Smith", 23));
		
		CurrentAccount accForSmith2 = new CurrentAccount(Account.generateAccNumber(),
				72000, new PersonUser("Smith", 23));
		
	
		
		System.out.println("For savings account:");
		
		System.out.println();
		
		accForSmith.withDrawAmount(105000);
		
		System.out.println("For current account:");
		
		System.out.println();
		
		accForSmith2.withDrawAmount(105000);
		
		System.out.println(accForSmith.toString());
		
		
		System.out.println();
		
		SavingsAccount accForkathy = new SavingsAccount(Account.generateAccNumber(), 78000,
				new PersonUser("Kathy", 30));
		
		CurrentAccount accForkathy2 = new CurrentAccount(Account.generateAccNumber(), 46000,
				new PersonUser("Kathy",30));
		
		
		
		System.out.println("For savings account:");
		
		System.out.println();
		
		accForkathy.withDrawAmount(10000);
		
		System.out.println("For current account:");
		
		System.out.println();
		
		accForkathy2.withDrawAmount(50000);
		
		System.out.println(accForkathy.toString());
		System.out.println(accForkathy2.toString());
		
	}

}
