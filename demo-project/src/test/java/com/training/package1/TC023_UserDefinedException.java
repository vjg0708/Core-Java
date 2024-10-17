package com.training.package1;

import java.util.Scanner;

class AgeException extends Exception{
	
	private int age;
	
	public AgeException(int age) {
		
		super(age + " is invalid");
		// TODO Auto-generated constructor stub
		
		this.age = age;
	}

	@Override
	public String toString() {
		return age + " is invalid, enter a valid age";
	}
	
	
}


class ExampleEmployee{
	
	private String empname;
	private int age;
	
	public void getDetails() throws AgeException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter your name : ");
		empname = sc.next();
		
		System.out.print("Enter your Age : ");
		age = sc.nextInt();
		
		if(age < 18) {
			
			throw new AgeException(age);
		}
		
		else {
			
			System.out.println("Data accepted");
		}
	}
}

public class TC023_UserDefinedException {
	
	public static void main(String[] args) {
		
		ExampleEmployee useEmp = new ExampleEmployee();
		
		try {
			
			useEmp.getDetails();
		}
		catch (AgeException e) {
			
			System.out.println("Exception occured : " + e.toString());
			
		}
		
	}
}
