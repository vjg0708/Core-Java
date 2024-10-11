package com.training.package1;
import java.util.*;
import static java.lang.Math.sqrt;

public class Lab_002 {
	
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
		
		System.out.println("Square root is : " + sqrt(n));
	}
}
