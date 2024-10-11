package com.training.package1;

public class TC009_WrapperandTypeCasting {
	
	public static void main(String[] args) {
		
		String numbers = "2345";
		int num = Integer.parseInt(numbers);
		
		
		int intConversion = (int)(10.0);
		
		System.out.println(num);
		System.out.println(intConversion);
	}
}
