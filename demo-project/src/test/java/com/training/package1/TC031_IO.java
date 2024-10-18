package com.training.package1;

public class TC031_IO {
	
	public static void main(String[] args) {
		
		StringBuffer string = new StringBuffer();
		
		char c;
		
		System.out.println("Enter a String : ");
		
		try {
			
			//reading input using input stream 
			while((c = (char) System.in.read())!= '\n'){
				
				string.append(c);
			}
		}
		catch (Exception e) {
			
			System.out.println("Error while reading : " + e.getMessage());
		}
		
		System.out.println("You entered : " + string.toString());
	}

}
