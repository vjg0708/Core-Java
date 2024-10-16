package com.training.package1;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Lab_013 {	
	
	public static ZonedDateTime getZonedDateTime(String zoneID) {
		
		ZonedDateTime zoneDate = ZonedDateTime.now(ZoneId.of(zoneID));
		
		return zoneDate;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Zone time of America/NewYork is : "+getZonedDateTime("America/New_York"));
		System.out.println("Zone time of Europe/London is : " + getZonedDateTime("Europe/London"));
		System.out.println("Zone time of Asia/Tokyo is : " + getZonedDateTime("Asia/Tokyo"));
		System.out.println("Zone time of US/Pacific is : " + getZonedDateTime("US/Pacific"));
		System.out.println("Zone time of  Africa/Cairo is : " + getZonedDateTime("Africa/Cairo"));
		System.out.println("Zone time of Australia/Sydney is : " + getZonedDateTime("Australia/Sydney"));
	}

}
