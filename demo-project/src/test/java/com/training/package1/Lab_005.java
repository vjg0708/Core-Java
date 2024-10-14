package com.training.package1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Lab_005 {
	
	public static void main(String[] args) {
		
		LocalDate trainingStartDate = LocalDate.of(2024, Month.SEPTEMBER, 25);
		
		DateTimeFormatter formatStartDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		
		int numberOfDays = 50;
		
		trainingStartDate.format(formatStartDate);
		
		LocalDate endDate  = trainingStartDate;
		
		DateTimeFormatter formatEndDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		
		
		for(int i = 0 ; i<=numberOfDays ; i++) {
			
			endDate = endDate.plusDays(1);
			
			if(DayOfWeek.SATURDAY != endDate.getDayOfWeek() &&
					DayOfWeek.SUNDAY != endDate.getDayOfWeek()) {
				i++;
				
			}
			
			
			
			
			
		}
		
		System.out.println("End Date of training : " + endDate.format(formatEndDate));
	}

}
