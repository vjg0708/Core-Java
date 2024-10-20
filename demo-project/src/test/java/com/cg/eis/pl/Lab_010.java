package com.cg.eis.pl;

import java.util.Scanner;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.Lab016_InvalidSalaryException;
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
		
		try {
			
			useService.addEmployeeDetails(empid, name, salary, designation);
			
		} catch (Lab016_InvalidSalaryException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Exception : " + e.displayMessage());
		}
		
		System.out.print("Enter Insurance Scheme : ");
		
		String scheme = sc.next();
		
		System.out.println("Employee details of mentioned scheme : "+ 
		scheme + " are : " + useService.getEmployeeFromScheme(scheme));
		
		useService.displayEmployeeDetails();
	}

}
