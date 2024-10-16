package com.training.package1;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Lab_011 {
	
	public static void main(String[] args) {
		
		LocalDate startingDate = LocalDate.of(2002, Month.AUGUST, 7);
		LocalDate nowDate = LocalDate.now();
		Period duration2 = Period.between(startingDate, nowDate);
		
		System.out.println(" Duration is : " +" " + duration2.getDays() + " days "+
				duration2.getMonths()+ " months " + duration2.getYears() + " years");
		
	}

}
