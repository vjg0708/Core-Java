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



	public void setAge(int age) {
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
	
	public void displayPersonDetails() {
		
		System.out.println("First Name : " +firstName+"\n"
				+"Last Name : " + lastName + "\n"
				+"Gender : " + gender + "\n"
				+"Age : " + this.calculateAge() + "\n"
				+"Weight : " + weight+"\n"
				+"Phone Number : " +phoneNumber);

	}
	
	public int calculateAge() {
		
		Period getAge = dateOfBirth.until(LocalDate.now());
		
		this.setAge(getAge.getYears());
		
		return this.getAge();
		
		
	}
	
	public String getFullName() {
		
		return firstName + lastName;
	}
	
}
