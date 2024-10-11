package com.training.package1;

public class TC007_UseStatic {
	
	static int a = 20;
	static int b;
	static final int finalNum = 10;
	
	static {
		
		System.out.println("inside static block");
		b = a*10;
	}
	
	public static void addNumbers(int c) {
		
		
		System.out.println("a :"+a);
		System.out.println("b :"+b);
		System.out.println("c :"+c);
		System.out.println("finalNumber : "+finalNum);
		System.out.println("Addition of numbers : "+ (a + b + c + finalNum));
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		addNumbers(10);
		//finalNum = 20; variables, methods with final cannot be changed
		
	}

}
