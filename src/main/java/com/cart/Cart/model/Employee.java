package com.cart.Cart.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	String employeeid;
	String employeename;
	String employeeaddress;
	String employeeemail;
	
	public Employee(String employeeid, String employeename, String employeeaddress, String employeeemail) {
		super();
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.employeeaddress = employeeaddress;
		this.employeeemail = employeeemail;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeeaddress() {
		return employeeaddress;
	}

	public void setEmployeeaddress(String employeeaddress) {
		this.employeeaddress = employeeaddress;
	}

	public String getEmployeeemail() {
		return employeeemail;
	}

	public void setEmployeeemail(String employeeemail) {
		this.employeeemail = employeeemail;
	}
	
	
	
}
