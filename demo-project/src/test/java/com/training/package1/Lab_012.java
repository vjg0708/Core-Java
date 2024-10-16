package com.training.package1;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Lab_012 {
	
	public static LocalDate checkExpiry(LocalDate pd, Period wp) {
		
		LocalDate expiryDate = pd.plusMonths(wp.getMonths());
		expiryDate = pd.plusYears(wp.getYears());
		
		return expiryDate;
	}
	
	
	public static void main(String[] args) {
		
		
		LocalDate purchasedDate = LocalDate.of(2024, 1, 15);
		Period warrantyperiod = Period.ofMonths(10);
		warrantyperiod = Period.ofYears(1);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMMM/YYYY");
		purchasedDate.format(format);
		
		System.out.println("The Date of Expiry is : "+checkExpiry(purchasedDate, warrantyperiod));
	}
}
