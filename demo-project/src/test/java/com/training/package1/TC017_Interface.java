package com.training.package1;

interface SimpleCalc{
	
	int number = 10;
	
	public void addNumbers(int a, int b);
}

class Calculation implements SimpleCalc{
	
	
	public void addNumbers(int a, int b) {
		
		System.out.println("Addition of two numbers is :" + (a+b));
	}
}

public class TC017_Interface {

	
	public static void main(String[] args) {
		
		SimpleCalc doCalc = new Calculation();
		
		doCalc.addNumbers(20, 30);
		
	}
}
