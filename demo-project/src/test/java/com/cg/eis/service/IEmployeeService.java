package com.cg.eis.service;

public interface IEmployeeService {
	
	public void addEmployeeDetails(long empid, String name, double salary,
			String scheme, String desg);
	
	public void checkInsuranceScheme();
	
	public void displayEmployeeDetails();

}
