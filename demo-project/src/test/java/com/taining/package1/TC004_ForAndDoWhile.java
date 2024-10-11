package com.taining.package1;

public class TC004_ForAndDoWhile {
	
	public static void main(String[] args) {
		
		int i = 1;
		
		do {
			
			System.out.println(i + "iteration");
			i++;
		}while(i<=5);
		
		for(i = 1;i<6;i++) {
			
			System.out.println(i);
		}
	}

}
