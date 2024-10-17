package com.cg.eis.service;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.Lab016_InvalidSalaryException;

public class EmployeeServiceImp implements IEmployeeService{
	
	Employee useEmployee = new Employee();
	
	@Override
	public void addEmployeeDetails(long empid, String name,
			double salary, String desg) throws Lab016_InvalidSalaryException {
		// TODO Auto-generated method stub
				
				useEmployee.setEmployeeId(empid);
				useEmployee.setEmployeeName(name);
				useEmployee.setDesignation(desg);
				useEmployee.setEmployeeSalary(salary);
				
	}

	@Override
	public void checkInsuranceScheme(String designation) {
		// TODO Auto-generated method stub
		
		if(designation.equals("Associate")) {
			
			useEmployee.setInsuranceScheme("Basic");
			System.out.println("Insurance scheme : "+useEmployee.getInsuranceScheme());
			
		}
		else if(designation.equals("SeniorAssociate")) {
			
			useEmployee.setInsuranceScheme("Intermediate");
			System.out.println("Insurance scheme : "+useEmployee.getInsuranceScheme());
		}
		
		else if(designation.equals("TeamLead")) {
			
			useEmployee.setInsuranceScheme("Pearl");
			System.out.println("Insurance scheme : "+useEmployee.getInsuranceScheme());
		}
		else if(designation.equals("Manager")) {
			
			useEmployee.setInsuranceScheme("Gold");
			System.out.println("Insurance scheme : "+useEmployee.getInsuranceScheme());
		}
		
	}

	@Override
	public void displayEmployeeDetails() {
		// TODO Auto-generated method stub
		System.out.println("The Employee Details are : "+ "\n"+
		useEmployee.toString());
	}
	
	
}
