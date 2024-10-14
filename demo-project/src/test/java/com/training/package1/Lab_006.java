package com.training.package1;
import java.util.Scanner;

public class Lab_006 {
	
	public static boolean checkPositiveString(String str) {
		
		int i = 0;
		while(i<str.length()-1) {
			
			if(str.charAt(i)>str.charAt(i+1)) {
				return false;
			}
			
			i++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		if(checkPositiveString(input)==true) {
			
			System.out.println("True");
		}
		
		else {
			System.out.println("False");
		}
		
	}

}
