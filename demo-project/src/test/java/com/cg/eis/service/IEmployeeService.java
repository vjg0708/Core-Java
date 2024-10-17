package com.cg.eis.service;

import com.cg.eis.exception.Lab016_InvalidSalaryException;

public interface IEmployeeService {
	
	public void addEmployeeDetails(long empid, String name, double salary,
			 String desg) throws Lab016_InvalidSalaryException;
	
	public void checkInsuranceScheme(String designation);
	
	public void displayEmployeeDetails();

}
