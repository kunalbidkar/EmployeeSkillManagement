package com.xp.employee.service;

import java.util.List;

import com.xp.employee.model.Employee;
import com.xp.employee.model.EmployeeSkill;

public interface ManagerService {
	
	public List<Employee> getEmployeeOfManager(int secureUserId);

	public Employee getSecureuserObject(String username);

	public List<EmployeeSkill> getAllPendingApprovals(Employee secureUser);

	public boolean approveEmpSkillRating(int empSkillId);

	public List<EmployeeSkill> getAllApprovedApprovals(Employee secureUser);

	public List<EmployeeSkill> getAllRejectedApprovals(Employee secureUser);

	public boolean rejectEmpSkillRating(int empSkillId);

}
