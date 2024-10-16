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
				if(i%2==1) {
					resultString = input.replace(input.charAt(i), '#');
				}
				
			}
			
			break;
			
		case 3:
			StringBuilder str = new StringBuilder();
			
			for (int i=0;i<input.length();i++) {
				
				char ch = input.charAt(i);
				if(str.indexOf(String.valueOf(ch))== -1) {
					
					str.append(ch);
				}
			}
			
			resultString = str.toString();
			break;
			
		case 4:
			StringBuilder str1 = new StringBuilder(input);
			
			for(int i = 0;i<input.length();i++) {
				
				if(i%2==1) {
					
					str1.setCharAt(i, Character.toUpperCase(input.charAt(i)));
				}
			}
			
			resultString = str1.toString();
			break;
			
		default:
			System.out.println("no valid choice");
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
		
		System.out.println("The operation performed on choice "+ 
		inputChoice +" is :" + perfromOperations(inputString, inputChoice) );
		
		
	}

}
