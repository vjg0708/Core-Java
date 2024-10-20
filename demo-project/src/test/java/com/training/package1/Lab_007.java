package com.training.package1;
import java.util.Scanner;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;



public class Lab_007 {
	
	public static void main(String[] args) {
		
		LocalDate currentDate = LocalDate.now();
		Scanner sc = new Scanner(System.in);
		
		String acceptedDate = sc.nextLine();
		
		LocalDate inputDate = LocalDate.parse(acceptedDate);
		
		Period duration = inputDate.until(currentDate);
		
		System.out.println(" Duration is : " + duration.get(ChronoUnit.YEARS)+" "
				+"Years"+" "+duration.get(ChronoUnit.MONTHS)+" "+"Months"+" "
				+duration.get(ChronoUnit.DAYS)+" "+"Days");
		
		
		
	}
}
