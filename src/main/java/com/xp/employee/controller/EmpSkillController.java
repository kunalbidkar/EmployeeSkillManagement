/**
 * 
 */
package com.xp.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xp.employee.model.Employee;
import com.xp.employee.model.EmployeeSkill;
import com.xp.employee.model.Skill;
import com.xp.employee.service.EmpSkillService;
import com.xp.employee.service.ManagerSkillService;

/**
 * @author Madhav
 *
 */
@Controller
public class EmpSkillController {

	@Autowired
	EmpSkillService empSkillService;
	
	@Autowired
	ManagerSkillService service;

	@RequestMapping(value = "/employee/addEmpSkill", method = RequestMethod.POST)
	public String empSkillRegistration(HttpServletRequest request, @ModelAttribute("empskills") EmployeeSkill emp, BindingResult bindingResult,
			Model model) {
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("secureUser");
		int empId = employee.getEmployeeId();
		
		Skill s1 = service.getSkillByID(emp.getSkillId());
		System.out.println("skill name "+s1.getSkillName());
		
		emp.setEmpId(empId);
		emp.setStatus("Pending");
		emp.setSkillName(s1.getSkillName());
		empSkillService.addEmpSkill(emp);
		return "redirect:/employee/empSkills";
	}

	EmployeeSkill editEmployeeSkill = null;
	@RequestMapping(value = "/employee/updateEmpSkill", method = RequestMethod.POST)
	public String empSkillUpdate(@ModelAttribute("empskills") EmployeeSkill emp, BindingResult bindingResult, Model model,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("secureUser");
		
		Skill s1 = service.getSkillByID(emp.getSkillId());
		System.out.println("skill name "+s1.getSkillName());
		
		editEmployeeSkill.setEmployeeRating(Integer.parseInt(request.getParameter("employeeRating")));
		editEmployeeSkill.setSkillName(s1.getSkillName());
		editEmployeeSkill.setSkillId(empSkillService.getSkillIdfromName(s1.getSkillName()));
		empSkillService.updateEmpSkills(editEmployeeSkill, employee);

		return "redirect:/employee/empSkills";
	}



	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/employee/editEmpSkill", method = RequestMethod.GET)
	public ModelAndView empSkillEdit(@ModelAttribute("command")  EmployeeSkill emp, HttpServletRequest request) {
		int approvalId = Integer.parseInt(request.getParameter("approvalId"));
		int id = Integer.parseInt(request.getParameter("id"));
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("secureUser");
		
		editEmployeeSkill = empSkillService.getSkillToBeEdit(approvalId);

		emp = empSkillService.getCurrentEmpSkills(id, sid); 
		 System.out.println(emp.getSkillId());
		 
		 Skill sk = service.getSkillByID(emp.getSkillId());
		
		 String str = sk.getSkillName();
		 System.out.println(str);
		 
		 List l = java.util.Arrays.asList(sk);
		 System.out.println(l);
		 
		List<Skill> list1 = empSkillService.getEmpSkillsExceptCurrent(emp.getSkillId(), employee);
		
		List<Skill> list = new ArrayList<Skill>();
		list.addAll(l);
		list.addAll(list1);
		 
		ModelAndView model = new ModelAndView("employeeeditskill");
		model.addObject("skillList", list);
		model.addObject("skillToBeEdit",editEmployeeSkill);
		
		return model;
	}
	
	@RequestMapping(value = "/employee/empSkills", method = RequestMethod.GET)
    public ModelAndView empSkills(HttpServletRequest request,ModelAndView model) {
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("secureUser");
		
    	List<EmployeeSkill> listEmpskills = empSkillService.getAllEmpSkills(employee);
    	
    	model.addObject("listEmpskills",listEmpskills);
    	
    	
    	model.setViewName("employeeskilllist");
         return model;
    }
	
	@RequestMapping(value = "/employee/newEmpSkill", method = RequestMethod.GET)
	public ModelAndView empSkillList(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		Employee employee = (Employee)session.getAttribute("secureUser");
		int empId = employee.getEmployeeId();
		model.addAttribute("empId", empId);
		model.addAttribute("employeeskills",new EmployeeSkill());
	//	model.addAttribute("EmpSkills", new EmployeeSkill());
		List<Skill> list = service.getAllSkill();
		return new ModelAndView("employeeaddskill", "skillList", list);
	}
}
