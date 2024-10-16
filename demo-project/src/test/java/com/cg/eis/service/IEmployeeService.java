package com.cg.eis.service;

public interface IEmployeeService {
	
	public void addEmployeeDetails(long empid, String name, double salary,
			 String desg);
	
	public void checkInsuranceScheme(String designation);
	
	public void displayEmployeeDetails();

}
