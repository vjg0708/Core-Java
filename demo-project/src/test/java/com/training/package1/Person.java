package com.training.package1;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	
	String firstName;
	String lastName;
	int age;
	double weight;
	long phoneNumber;
	CheckGender gender;
	LocalDate dateOfBirth;
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	static enum CheckGender{
		M,F;
	}
	
	
	public long getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public Person(String firstName, String lastName,  double weight) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.weight = weight;
	}
	
	

	public int getAge() {
		return age;
	}



	public void setAge(int age){
		
		this.age = age;
	}



	public double getWeight() {
		return weight;
	}



	public void setWeight(double weight) {
		this.weight = weight;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public CheckGender getGender() {
		return gender;
	}
	public void setGender(CheckGender gender) {
		this.gender = gender;
	}
	
	public void displayPersonDetails() throws Lab015_InvalidAgeException  {
		
		System.out.println("First Name : " +firstName+"\n"
				+"Last Name : " + lastName + "\n"
				+"Gender : " + gender + "\n"
				+"Age : " + calculateAge(getDateOfBirth()) + "\n"
				+"Weight : " + weight+"\n"
				+"Phone Number : " +phoneNumber);

	}
	
	public int calculateAge(LocalDate dob) throws Lab015_InvalidAgeException {
		
		Period ageCal = dob.until(LocalDate.now());
		
		setAge(ageCal.getYears());
		
		if(this.getAge()<15) {
			
			throw new Lab015_InvalidAgeException(this.getAge());
		}
		
		return this.getAge();
		
		
		
	}
	
	public String getFullName() throws Lab014_InvalidNameException {
		
		if(firstName.isEmpty() && lastName.isEmpty()) {
			
			throw new Lab014_InvalidNameException(lastName, firstName);
		}
		
		return firstName + " " + lastName;
	}
	
}
