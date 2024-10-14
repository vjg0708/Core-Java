package com.training.package1;

public class TC011_StringBuffer {
	
	public static void main(String[] args) {
		
		StringBuffer str = new StringBuffer("Hello All");
		
		System.out.println(str.append("Welcome aboard"));
		System.out.println(str.reverse());
		
		StringBuilder str2 = new StringBuilder(str);
		
		System.out.println(str2.replace(5, 9, "*").insert(10, "Hello"));
	}

}
