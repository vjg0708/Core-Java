package com.training.package1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TC018_Regex {
	
	public static void main(String[] args) {
		
		String input = "Apple";
		String pattern = "apple";
		
		boolean checkPattern = Pattern.matches("Apple", input);
		//checks whether the pattern is matched to the string
		
		System.out.println("Pattern Match is : " +
		checkPattern);
		
		String  inputWords = "Shop, Mop, Chopping, Hopping";
		Pattern p1 = Pattern.compile("hop");
		//uses the string as pattern
		
		Matcher m1 = p1.matcher(inputWords);
		//interrupts to match the string with given pattern
		
		System.out.println(m1.matches());
		//displays the result of above match operation
		//matches string 
		while(m1.find()) {
			
			System.out.println(m1.group() + " : "+
			m1.start()+" : "+m1.end());
		}
		
		String input1 = "Exo1";
		Pattern p2 = Pattern.compile("^[A-Z].*[0-9]$");
		//using regex constructs
		Matcher m2 = p2.matcher(input1);
		//matches characters and digit
		if(!m2.find()) {
			
			System.err.print("Enter the code with Uppercase alphabet and end with a digit");
			
		}
		else {
			System.out.println("Found");
		}
		
		String phnNo = "9228245939";
		Pattern p4 = Pattern.compile("^\\d{10}$");
		
		Matcher m3 = p4.matcher(phnNo);
		//matches for mobile number
		if(m3.find()) {
			
			System.out.println("mobile number matches");
			
		}
		else {
			System.out.println("mobile number not matches");
		}
		
		String splCh = "***&&&###!";
		Pattern p5 = Pattern.compile("^\\D{10}$");
		
		Matcher m4 = p5.matcher(splCh);
		//matches for special characters
		if(m4.find()) {
			
			System.out.println("spl chs matched");
			
		}
		else {
			System.out.println("spl chs not matched");
		}
		
		String whiteSpace = "Welcome Onboard";
		Pattern p6 = Pattern.compile("^.*\\s.*$");
		
		Matcher m5 = p6.matcher(whiteSpace);
		//matches for whitespace
		if(m5.find()) {
			
			System.out.println("whitespace matched");
			
		}
		else {
			System.out.println("whitespace not matched");
		}
		
		Pattern p7 = Pattern.compile("\\S");
		Matcher m6 = p7.matcher(whiteSpace);
		
		//to match non whitespace characters
		while(m6.find()) {
			
			System.out.println(m6.group() + " : "+
			m6.start());
			// group() : start : end()
			//character pos : starting pos : ending pos
		}
		
		String emailId = "200707080@rajalakshmi.edu.in";
		Pattern emailPtn = Pattern.compile("^[a-zA-Z._0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z.]{2,6}$");
											//or use "^[\\W._]+@[\\W]+\\.[\\W.]{2,6}$"
		Matcher matchMail = emailPtn.matcher(emailId);
		
		if(matchMail.find()) {
			
			System.out.println("Valid email");
		}
		
		else {
			System.out.println("Not a valid email");
		}
		
		
	}

}
