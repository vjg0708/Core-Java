package com.training.package1;

public class TC025_VarArgs {
	
	public static void printDetails(String message, int...numbers) {
		
		System.out.println(message);
		
		for(int i : numbers) {
			
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		
		printDetails("Hello", 1,2,3,4,5,6);
	}

}
