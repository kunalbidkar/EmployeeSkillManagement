/**
 * 
 */
package com.xp.employee.model;

import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class Employee {

	private int employeeId;

	private String employeeFirstName;

	private String employeeLastName;

	private String employeeEmail;

	private long employeeMobNo;

	private String employeeAddress;

	private String employeeGender;

	private String employeeDOB;

	private String employeeDOJ;

	private String employeeStatus;

	private String employeeRole;

	private String managerId;

	private String managerName;

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public long getEmployeeMobNo() {
		return employeeMobNo;
	}

	public void setEmployeeMobNo(long employeeMobNo) {
		this.employeeMobNo = employeeMobNo;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeeDOB() {
		return employeeDOB;
	}

	public void setEmployeeDOB(String employeeDOB) {
		this.employeeDOB = employeeDOB;
	}

	public String getEmployeeDOJ() {
		return employeeDOJ;
	}

	public void setEmployeeDOJ(String employeeDOJ) {
		this.employeeDOJ = employeeDOJ;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
}
