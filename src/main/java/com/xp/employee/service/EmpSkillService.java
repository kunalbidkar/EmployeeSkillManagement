/**
 * 
 */
package com.xp.employee.service;

import java.util.List;

import com.xp.employee.model.Employee;
import com.xp.employee.model.EmployeeSkill;
import com.xp.employee.model.Skill;

/**
 * @author Madhav
 *
 */
public interface EmpSkillService {

	public int addEmpSkill(EmployeeSkill e);

	public List<EmployeeSkill> getAllEmpSkills(Employee employee);

	public int updateEmpSkills(EmployeeSkill e, Employee employee);

	public EmployeeSkill getEmpSkills(int id);

	public EmployeeSkill getCurrentEmpSkills(int id, int sid );

	public List<Skill> getEmpSkillsExceptCurrent(int id, Employee employee);

	public EmployeeSkill getSkillToBeEdit(int approvalId);

	public int getSkillIdfromName(String skillName);

}
