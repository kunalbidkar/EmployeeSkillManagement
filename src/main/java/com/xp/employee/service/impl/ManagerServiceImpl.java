package com.xp.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.employee.dao.ManagerDao;
import com.xp.employee.model.Employee;
import com.xp.employee.model.EmployeeSkill;
import com.xp.employee.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	ManagerDao managerDao;
	
	public List<Employee> getEmployeeOfManager( int secureUserId){
		return managerDao.getEmployeeOfManager(secureUserId);
	}

	public Employee getSecureuserObject(String username) {
		return managerDao.getSecureuserObject(username);
	}

	public List<EmployeeSkill> getAllPendingApprovals(Employee secureUser) {
		return managerDao.getAllPendingApprovals(secureUser);
	}

	public boolean approveEmpSkillRating(int empSkillId) {
		return managerDao.approveEmpSkillRating(empSkillId);
	}

	public List<EmployeeSkill> getAllApprovedApprovals(Employee secureUser) {
		return managerDao.getAllApprovedApprovals(secureUser);
	}

	public List<EmployeeSkill> getAllRejectedApprovals(Employee secureUser) {
		return managerDao.getAllRejectedApprovals(secureUser);
	}

	public boolean rejectEmpSkillRating(int empSkillId) {
		return managerDao.rejectEmpSkillRating(empSkillId);
	}
}
