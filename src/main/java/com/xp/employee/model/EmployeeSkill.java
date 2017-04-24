package com.xp.employee.model;

import org.springframework.stereotype.Component;

@Component
public class EmployeeSkill {
	
	private int approvalId;
	private int empId;
	private String empName;
	private int managerId;
	private int skillId; 
	private String status;
	private String comments;
	private String skillName;
	private int employeeRating; 
	private String managerComments;
	
	
	@Override
	public String toString() {
		return "EmployeeSkill [empId=" + empId + ", managerId=" + managerId + ", skillId=" + skillId + ", status="
				+ status + ", comments=" + comments + ", skillName=" + skillName + ", EmployeeRating=" + employeeRating
				+ ", managerComments=" + managerComments + "]";
	}
	
	public int getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getEmployeeRating() {
		return employeeRating;
	}

	public void setEmployeeRating(int employeeRating) {
		this.employeeRating = employeeRating;
	}

	public String getManagerComments() {
		return managerComments;
	}

	public void setManagerComments(String managerComments) {
		this.managerComments = managerComments;
	}

	
	
}
