package com.cg.eis.bean;

public class Employee {
	
	private long employeeId;
	private String employeeName;
	private double employeeSalary;
	private String designation;
	private String insuranceScheme;
	
	
	
	public Employee() {
	}


	public Employee(long employeeId, String employeeName,
			double employeeSalary, String designation) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeSalary = employeeSalary;
		this.designation = designation;
	}


	public long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public double getEmployeeSalary() {
		return employeeSalary;
	}


	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getInsuranceScheme() {
		return insuranceScheme;
	}


	public void setInsuranceScheme(String insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + 
				employeeName + ", employeeSalary="
				+ employeeSalary + ", designation=" + designation + 
				", insuranceScheme=" + insuranceScheme + "]";
	}
	
	
	
	
	
}
