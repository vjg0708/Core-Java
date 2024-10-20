package com.cg.eis.service;

import java.util.HashMap;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.Lab016_InvalidSalaryException;

public class EmployeeServiceImp implements IEmployeeService{
	
	Employee useEmployee = new Employee();
	
	HashMap<String, Employee> employeeData;
	
	@Override
	public void addEmployeeDetails(long empid, String name,
			double salary, String desg) throws Lab016_InvalidSalaryException {
		// TODO Auto-generated method stub
				
				useEmployee.setEmployeeId(empid);
				useEmployee.setEmployeeName(name);
				useEmployee.setDesignation(desg);
				useEmployee.setEmployeeSalary(salary);
				
				employeeData =  this.storeEmployeeDetails(this.checkInsuranceScheme(desg),
						useEmployee);
	}

	@Override
	public String checkInsuranceScheme(String designation) {
		// TODO Auto-generated method stub
		
		String insuranceScheme = null;
		
		if(designation.equals("Associate")) {
			
			useEmployee.setInsuranceScheme("Basic");
			
			insuranceScheme = useEmployee.getInsuranceScheme();
			
		}
		else if(designation.equals("SeniorAssociate")) {
			
			useEmployee.setInsuranceScheme("Intermediate");
			insuranceScheme = useEmployee.getInsuranceScheme();
		}
		
		else if(designation.equals("TeamLead")) {
			
			useEmployee.setInsuranceScheme("Pearl");
			insuranceScheme = useEmployee.getInsuranceScheme();
		}
		else if(designation.equals("Manager")) {
			
			useEmployee.setInsuranceScheme("Gold");
			insuranceScheme = useEmployee.getInsuranceScheme();
		}
		
		return insuranceScheme;
		
		
	}
	
	

	@Override
	public HashMap<String, Employee> storeEmployeeDetails(String insuranceScheme,
			Employee empObj) {
		// TODO Auto-generated method stub
		
		HashMap<String, Employee> employeeData = new HashMap<String, Employee>();
		
		employeeData.put(insuranceScheme, empObj);
		
		return employeeData;
	}

	@Override
	public void displayEmployeeDetails() {
		// TODO Auto-generated method stub
		System.out.println("The Employee Details are : "+ "\n"+
				employeeData);
	}

	@Override
	public Employee getEmployeeFromScheme(String scheme) {
		// TODO Auto-generated method stub
		return employeeData.get(scheme);
	}
	
	
}
