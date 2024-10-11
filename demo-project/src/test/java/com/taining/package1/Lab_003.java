package com.taining.package1;

import com.taining.package1.Person.CheckGender;

public class Lab_003 {
	
	public static void main(String[] args) {
		Person createPerson = new Person("Ajith", "Kumar", 30, 75.5);
		
		createPerson.setPhoneNumber(92883419347l);
		createPerson.setGender(CheckGender.M);
		
		System.out.println("Person Details");
		System.out.println("______________________");
		System.out.println();
		
		createPerson.displayPersonDetails();
		
		
	}

}
