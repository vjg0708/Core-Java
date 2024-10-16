package com.cg.eis.pl;

import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.service.EmployeeServiceImp;
import com.cg.eis.service.IEmployeeService;

public class Lab_010 {
	
	public static void main(String[] args) {
		
		
		
		IEmployeeService useService = new EmployeeServiceImp();
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter id : ");
		
		long empid = sc.nextLong();
		
		System.out.print("Enter empName : ");
		
		String name = sc.next();
		
		System.out.print("Enter Salary : ");
		
		double salary = sc.nextDouble();
		
		System.out.print("Enter designation : ");
		
		String designation = sc.next();
		
		useService.addEmployeeDetails(empid, name, salary, designation);
		
		useService.checkInsuranceScheme(designation);
		
		useService.displayEmployeeDetails();
	}

}
