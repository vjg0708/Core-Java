package com.cg.eis.pl;

import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeServiceImp;
import com.cg.eis.service.IEmployeeService;

public class Lab_010 {
	
	public static void main(String[] args) {
		
		
		
		IEmployeeService useService = new EmployeeServiceImp();
		
		useService.addEmployeeDetails(1001, "Harrish", 50000, "Basic", "AssEng");
		
		useService.checkInsuranceScheme();
		
		useService.displayEmployeeDetails();
	}

}
