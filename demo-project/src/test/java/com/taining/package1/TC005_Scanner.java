package com.taining.package1;
import java.util.*;


public class TC005_Scanner {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		
		int n = sc.nextInt();
		
		if(n>=0) {
			
			System.out.println("Positive");
		}
		else {
			System.out.println("Negative");
		}
	}
}
