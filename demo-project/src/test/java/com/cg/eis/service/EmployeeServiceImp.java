package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImp implements IEmployeeService{
	
	Employee useEmployee = new Employee();
	
	
	public void addEmployeeDetails(long empid, String name,
			double salary, String scheme, String desg) {
		// TODO Auto-generated method stub
				
				useEmployee.setEmployeeId(empid);
				useEmployee.setEmployeeName(name);
				useEmployee.setEmployeeSalary(salary);
				useEmployee.setInsuranceScheme(scheme);
				useEmployee.setDesignation(desg);
	}

	@Override
	public void checkInsuranceScheme() {
		// TODO Auto-generated method stub
		
		if(useEmployee.getEmployeeSalary()>=25000 && useEmployee.getDesignation()=="AssEng") {
			
			System.out.println("The employee insurance scheme is : " + 
			useEmployee.getInsuranceScheme());
		}
		
		System.out.println("Exit");
		
	}

	@Override
	public void displayEmployeeDetails() {
		// TODO Auto-generated method stub
		System.err.println("The Employee Details are : "+ "\n"+
		useEmployee.toString());
	}
	
	
}
