package com.xp.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xp.employee.model.Employee;
import com.xp.employee.model.EmployeeSkill;
import com.xp.employee.service.EmployeeService;
import com.xp.employee.service.ManagerService;

/**
 * 
 * @author Bimal Dhimmar
 * 
 *  Manage all the servlet request of the employee related tasks.
 *         
 *  Please follow servlet naming convention, i.e employee related requests start with "/manger" 
 */
@Controller
public class ManagerController {
	
	@Autowired
    ManagerService managerService;
	
	@Autowired
	EmployeeService empService;
	
	
	@RequestMapping(value = "/manager/viewMyEmployee", method = RequestMethod.GET)
	public ModelAndView mangePendingApprovals(HttpServletRequest request, HttpServletResponse responce) {
		ModelAndView model = new ModelAndView("managerShowEmployees");
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("secureUser");
		model.addObject("listEmp", managerService.getEmployeeOfManager(employee.getEmployeeId()));
		return model;
	}
	
	@RequestMapping(value = "/manager/managePendingApprovals", method = RequestMethod.GET)
	public ModelAndView viewPendingApprovals(HttpServletRequest request, HttpServletResponse responce) {
		ModelAndView model = new ModelAndView("managerApprovals");
		
		HttpSession session = request.getSession();
		Employee secureUser = (Employee)session.getAttribute("secureUser");
		
		List<EmployeeSkill> employeesSkills = managerService.getAllPendingApprovals(secureUser);
		employeesSkills = bindEmployeeName(employeesSkills);
		model.addObject("employeeSkillsPendingForApprovals",employeesSkills );
		model.addObject("pendingApprovalsCount",employeesSkills.size() );
		
		List<EmployeeSkill> employeesApprovedSkills = managerService.getAllApprovedApprovals(secureUser);
		employeesApprovedSkills = bindEmployeeName(employeesApprovedSkills);
		model.addObject("employeeSkillsApprovedForApprovals",employeesApprovedSkills );
		
		List<EmployeeSkill> employeesRejectedSkills = managerService.getAllRejectedApprovals(secureUser);
		employeesRejectedSkills = bindEmployeeName(employeesRejectedSkills);
		model.addObject("employeeSkillsRejectedForApprovals",employeesRejectedSkills );
		
		return model;
	}
	
	//Get Employee names from their Id.
	public List<EmployeeSkill> bindEmployeeName(List<EmployeeSkill> list){
		for(EmployeeSkill empskill : list){
			Employee emp = empService.getEmployee(empskill.getEmpId());
			empskill.setEmpName(emp.getEmployeeFirstName()+" "+emp.getEmployeeLastName());
		}
		return list;
	}
	
	@RequestMapping(value = "/manager/approveSkillrating", method = RequestMethod.GET)
	public ModelAndView approveEmpSkillRating(HttpServletRequest request, HttpServletResponse responce) {
		int empSkillId = Integer.parseInt(request.getParameter("id"));
		ModelAndView model = new ModelAndView("managerApprovals");
		
		
		HttpSession session = request.getSession();
		Employee secureUser = (Employee)session.getAttribute("secureUser");
		
		managerService.approveEmpSkillRating(empSkillId);
		List<EmployeeSkill> employeesSkills = managerService.getAllPendingApprovals(secureUser);
		employeesSkills = bindEmployeeName(employeesSkills);
		model.addObject("employeeSkillsPendingForApprovals",employeesSkills );
		model.addObject("pendingApprovalsCount",employeesSkills.size() );
		
		List<EmployeeSkill> employeesApprovedSkills = managerService.getAllApprovedApprovals(secureUser);
		employeesApprovedSkills = bindEmployeeName(employeesApprovedSkills);
		model.addObject("employeeSkillsApprovedForApprovals",employeesApprovedSkills );
		
		List<EmployeeSkill> employeesRejectedSkills = managerService.getAllRejectedApprovals(secureUser);
		employeesRejectedSkills = bindEmployeeName(employeesRejectedSkills);
		model.addObject("employeeSkillsRejectedForApprovals",employeesRejectedSkills );
		
		
		return model;
	}
	
	
	
	
	@RequestMapping(value = "manager/rejectSkillrating", method = RequestMethod.GET)
	public ModelAndView rejectEmpSkillRating(HttpServletRequest request, HttpServletResponse responce) {
		int empSkillId = Integer.parseInt(request.getParameter("id"));
		ModelAndView model = new ModelAndView("managerApprovals");
		
		HttpSession session = request.getSession();
		Employee secureUser = (Employee)session.getAttribute("secureUser");
	
		managerService.rejectEmpSkillRating(empSkillId);
		List<EmployeeSkill> employeesSkills = managerService.getAllPendingApprovals(secureUser);
		employeesSkills = bindEmployeeName(employeesSkills);
		model.addObject("employeeSkillsPendingForApprovals",employeesSkills );
		model.addObject("pendingApprovalsCount",employeesSkills.size() );
		
		List<EmployeeSkill> employeesApprovedSkills = managerService.getAllApprovedApprovals(secureUser);
		employeesApprovedSkills = bindEmployeeName(employeesApprovedSkills);
		model.addObject("employeeSkillsApprovedForApprovals",employeesApprovedSkills );
		
		
		List<EmployeeSkill> employeesRejectedSkills = managerService.getAllRejectedApprovals(secureUser);
		employeesRejectedSkills = bindEmployeeName(employeesRejectedSkills);
		model.addObject("employeeSkillsRejectedForApprovals",employeesRejectedSkills );
		
		return model;
	}
	
	
	
	

	
}
