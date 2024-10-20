package com.cg.eis.service;

import java.util.HashMap;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.Lab016_InvalidSalaryException;

public interface IEmployeeService {
	
	public void addEmployeeDetails(long empid, String name, double salary,
			 String desg) throws Lab016_InvalidSalaryException;
	
	public String checkInsuranceScheme(String designation);
	
	public void displayEmployeeDetails();
	
	public HashMap<String, Employee> storeEmployeeDetails(String insuranceScheme,
			Employee empObj);
	
	public Employee getEmployeeFromScheme(String scheme);

}
