package com.training.package1;

import java.time.LocalDate;

import com.training.package1.Person.CheckGender;

public class Lab_003 {
	
	public static void main(String[] args) {
		Person createPerson = new Person("Ajith", "Kumar", 30, 75.5);
		
		createPerson.setPhoneNumber(92883419347l);
		createPerson.setGender(CheckGender.M);
		createPerson.setDateOfBirth(LocalDate.parse("2002-08-07"));
		
		System.out.println("Person Details");
		System.out.println("______________________");
		System.out.println();
		
		createPerson.displayPersonDetails();
		System.out.println("Current Age of Person is : " + createPerson.calculateAge());
		System.out.println("Person Full name is : " + createPerson.getFullName());
		
		
	}

}
