package com.training.package1;
import java.util.Scanner;

public class Lab_004 {
	
	public static String perfromOperations(String input, int ip) {
		
		String resultString = null;
		
		switch(ip) {
		
		case 1:
			resultString = input.concat(input);
			break;
		
		
		case 2:
			for(int i = 0;i<input.length();i++) {
				if(i%2==0) {
					continue;
				}
				else {
					resultString = input.replace(input.charAt(i), '#');
				}
			}
			
			break;
			
			
		}
		
		return resultString;
		

	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Enter a string");
		
		Scanner sc = new Scanner(System.in);
		
		String inputString = sc.nextLine();
		
		System.out.println("Enter a choice for performing operation");
		
		int inputChoice = sc.nextInt();
		
		System.out.println("The opertion performed on choice "+ 
		inputChoice +" is :" + perfromOperations(inputString, inputChoice) );
		
		
	}

}
