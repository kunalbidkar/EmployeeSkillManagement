package com.xp.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.employee.dao.EmpSkillDao;
import com.xp.employee.model.Employee;
import com.xp.employee.model.EmployeeSkill;
import com.xp.employee.model.Skill;
import com.xp.employee.service.EmpSkillService;

@Service
public class EmpSkillServiceImpl implements EmpSkillService {

	@Autowired
	EmpSkillDao dao;

	public int addEmpSkill(EmployeeSkill e) {
	
		return dao.addEmpSkill(e);
	}

	public List<EmployeeSkill> getAllEmpSkills(Employee employee) {
		
		return dao.getAllEmpSkills(employee);
	}

	public int updateEmpSkills(EmployeeSkill e, Employee employee) {
		
		return dao.updateEmpSkills(e, employee);
	}

	public EmployeeSkill getEmpSkills(int id) {
		
		return dao.getEmpSkills(id);
	}

	public EmployeeSkill getCurrentEmpSkills(int id, int sid) {
		
		return dao.getCurrentEmpSkills(id, sid);
	}

	public List<Skill> getEmpSkillsExceptCurrent(int id, Employee employee) {
		
		return dao.getEmpSkillsExceptCurrent(id, employee);
	}

	public EmployeeSkill getSkillToBeEdit(int approvalId) {
		return dao.getSkillToBeEdit(approvalId);
	}

	public int getSkillIdfromName(String skillName) {
		return dao.getSkillIdfromName(skillName);
	}

}
