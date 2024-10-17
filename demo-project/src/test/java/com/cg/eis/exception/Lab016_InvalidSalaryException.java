package com.cg.eis.exception;

public class Lab016_InvalidSalaryException extends Exception{
	
	private double salary;
	
	public Lab016_InvalidSalaryException(double salary) {
		
		super(salary + " is less than company provided salary pay");
		this.salary = salary;
	}
	
	public String displayMessage() {
		
		return " the mentioned salary " + salary + " is invalid, enter a valid salary";
		
	}

}
