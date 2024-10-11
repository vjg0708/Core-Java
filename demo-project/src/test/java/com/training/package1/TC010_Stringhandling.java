package com.training.package1;

public class TC010_Stringhandling {
	
	public static void main(String[] args) {
		
		String str1 = new String("Pooja");
		
		String str2 = str1;
		
		str2 = "Sreeja";
		
		System.out.println(str1);
		System.out.println(str2);
		
		String str3 = "This is a beautiful day to start the work";
		
		System.out.println(str3.length());
		System.out.println(str3.charAt(10));
		System.out.println(str3.concat(", may this day give you delight"));
	}

}
