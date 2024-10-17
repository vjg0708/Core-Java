package com.training.package1;

public class Lab014_InvalidNameException extends Exception{
	
	private String fname;
	private String lname;
	
	public Lab014_InvalidNameException(String name1, String name2) {
		
		super(name1 + name2 + " both names are empty");
		this.fname = name1;
		this.lname = name2;
	}
	
	public String printMessage() {
		
		return " name is empty, enter valid name";
	}
	

}
