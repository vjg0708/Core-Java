package com.training.package1;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class TC012_DateTime {
	
	public static void main(String[] args) {
		
		Instant currentTime = Instant.now();//shows current time
		
		System.out.println("Current Time is : " + currentTime); //2024-10-14T04:30:59.712212600Z
		
		LocalDate currentLocalDate = LocalDate.now(); // shows current localDate
		
		System.out.println("The local date is : " + currentLocalDate);//2024-10-14
		System.out.println("The next day : "+ currentLocalDate.plusDays(1));/*adds days 
		2024-10-15*/
		
		System.out.println("The previous day : " + currentLocalDate.minusDays(1));/*shows 
		previous day*/
		System.out.println("The previous month  : "+ currentLocalDate.minusMonths(1).getMonth());
		//getting the month as month name from date of pervius month
		
		System.out.println(currentLocalDate.isLeapYear());
		//checks for leap year
		
		System.out.println(currentLocalDate.withDayOfMonth(16));//2024-10-16
		
		ZonedDateTime zoneTime = ZonedDateTime.now();
		System.out.println("Zone time : "+ zoneTime);
		//2024-10-14T10:16:20.128379500+05:30[Asia/Calcutta]
		
		ZonedDateTime timeOfParis = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		System.out.println(timeOfParis);//2024-10-14T06:48:26.229334100+02:00[Europe/Paris]
		
		System.out.println("The next day : "+ timeOfParis.plusDays(1));
		
		System.out.println("The previous day : " + timeOfParis.minusDays(1));
		
		System.out.println("The previous month  : "+ timeOfParis.minusMonths(1).getMonth());
		//getting the month as month name from date of pervius month
		
		//method not available :System.out.println(timeOfParis.isLeapYear());
		//checks for leap year
		
		System.out.println(timeOfParis.withDayOfMonth(20));
		// shows date of the day specified in current month :2024-10-20T06:54:25.566037400+02:00[Europe/Paris]

		ZonedDateTime timeOfAustralia = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
		
		
		System.out.println("Time of Australia : " + timeOfAustralia);
		
		LocalDate startDate = LocalDate.of(2024, 9, 25);//start date
		
		LocalDate endDate = LocalDate.of(2024, 12, 6);//end date
		
		Period totalPeriod = startDate.until(endDate); // calculates the total time period
		
		System.out.println("Total period of days : "+ totalPeriod.get(ChronoUnit.DAYS));
		//extracts the no of days from calculated period
		System.out.println("Total period of months : "+ totalPeriod.get(ChronoUnit.MONTHS));
		//extracts no of months from calculated period
		System.out.println("Total period : "+ totalPeriod.get(ChronoUnit.YEARS));
		//extracts no of years from calculated period
		
		DateTimeFormatter format = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		
		
		System.out.println("Formatted current locadate : " +currentLocalDate.format(format));
		//14 October 2024
		System.out.println(timeOfParis.format(format));
		System.out.println(timeOfAustralia.format(format));
		
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MMMM/YYYY");
		
		System.out.println("Formatted current locadate : " +currentLocalDate.format(pattern));
		//14 October 2024
		System.out.println(timeOfParis.format(pattern));
		System.out.println(timeOfAustralia.format(pattern));
		
		
		


	}
}
