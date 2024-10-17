package com.training.package1;

public class Lab015_InvalidAgeException extends Exception{
	
	private int age;
	
	public Lab015_InvalidAgeException(int age) {
		
		super(age + " is invalid or less than criteria, enter a vali one");
		
		this.age = age;
	}
	
	public String printMessage() {
		
		return age + " is less than the given criteria, enter above given age criteria";
	}

}
