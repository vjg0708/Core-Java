package com.training.package1;

import java.time.LocalDate;

import com.training.package1.Person.CheckGender;

public class Lab_003 {
	
	public static void main(String[] args) /*throws Lab014_InvalidNameException*/ {
		Person createPerson = new Person("Harrish", "Vijay", 75.5);
		
		createPerson.setPhoneNumber(92883419347l);
		createPerson.setGender(CheckGender.M);
		createPerson.setDateOfBirth(LocalDate.parse("2002-08-07"));
		
		System.out.println("Person Details");
		System.out.println("______________________");
		System.out.println();
		
		try {
			
			
			createPerson.calculateAge(createPerson.dateOfBirth);
			createPerson.displayPersonDetails();
			
			
		} catch (Lab015_InvalidAgeException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Exception occured : " + e.printMessage());
		}
		
		
		
		
		try {
			
			System.out.println("Person Full name is : " + createPerson.getFullName());
		}
		catch(Lab014_InvalidNameException e) {
			
			System.out.println("Exception occured : " + e.printMessage());
			System.out.println(e.getMessage());
		}//using try-catch
		
		//System.out.println("Person Full name is : " + createPerson.getFullName());
		//using throws declaration in main method
		
		
		
		
	}

}
