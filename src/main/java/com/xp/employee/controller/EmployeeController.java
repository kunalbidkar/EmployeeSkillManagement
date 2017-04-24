package com.xp.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xp.employee.model.Employee;
import com.xp.employee.service.EmployeeService;

@Controller
@Transactional
public class EmployeeController {

	public EmployeeController() {
	}

	@Autowired
	EmployeeService service;

	@RequestMapping(value = "/admin/newEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployeeForm() {
		ModelAndView model = new ModelAndView("employeeRegister");
		model.addObject("employeeList", service.getAllEmployee());
		model.addObject("listManagers", service.getAllManagers());
		model.addObject("employee", new Employee());
		return model;
	}

	@RequestMapping(value = "/admin/listEmployee", method = RequestMethod.GET)
	public ModelAndView listEmployee(ModelAndView model) {

		List<Integer> employeeIds = new ArrayList<Integer>();
		List<Employee> listEmp = service.getAllEmployee();

		for (Employee emp : listEmp) {
			System.out.println(emp);
			employeeIds.add((Integer.parseInt(emp.getManagerId())));
			Employee manager = (service.getEmployee(Integer.parseInt(emp.getManagerId())));
			emp.setManagerName(manager.getEmployeeFirstName() + " " + manager.getEmployeeLastName());
		}

		model.addObject("listEmp", listEmp);
		model.setViewName("adminhome");
		return model;
	}

	@RequestMapping(value = "/admin/addEmployee", method = RequestMethod.POST)
	public String registration(@ModelAttribute("employee") Employee emp, BindingResult bindingResult, Model model) {

		if (emp.getEmployeeId() == 0) {

			if (emp.getManagerId().equals("0") && emp.getEmployeeRole().equalsIgnoreCase("ROLE_MANAGER")) {
				emp.setManagerId("1");
				service.addEmployee(emp);

			} else if (emp.getManagerId().equals("0") && (emp.getEmployeeRole().equalsIgnoreCase("ROLE_EMPLOYEE"))) {
				return "redirect:/admin/newEmployee";
			} else {
				service.addEmployee(emp);
			}
		} else {
			service.updateEmployee(emp);
		}
		return "redirect:/admin/listEmployee";

	}

	@RequestMapping(value = "/admin/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employee") Employee emp, BindingResult bindingResult, Model model) {

		if (emp.getManagerId().equals("0")) {
			return "redirect:/admin/newEmployee";

		} else {
			service.updateEmployee(emp);
		}

		return "redirect:/admin/listEmployee";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/editEmployee", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = service.getEmployee(employeeId);

		Employee emp = service.getEmployeeCurrentManager(employeeId);
		List list1 = java.util.Arrays.asList(emp);
		List list2 = service.getOtherManager(employeeId);

		List listManagers = new ArrayList();
		listManagers.addAll(list1);
		listManagers.addAll(list2);
		ModelAndView model = new ModelAndView("editemployee");
		model.addObject("listManagers", listManagers);
		model.addObject("employee", employee);

		return model;
	}

	@RequestMapping(value = "/admin/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		service.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/admin/listEmployee");
	}

	@RequestMapping(value = "/admin/listInactiveEmployee", method = RequestMethod.GET)
	public ModelAndView listInactiveEmployee(ModelAndView model) {

		List<Employee> listEmp = service.getAllEmployee();
		model.addObject("listEmp", listEmp);

		List<Integer> employeeIdsActive = new ArrayList<Integer>();

		for (Employee emp : listEmp) {
			System.out.println(emp);
			employeeIdsActive.add((Integer.parseInt(emp.getManagerId())));
			Employee manager = (service.getEmployee(Integer.parseInt(emp.getManagerId())));
			emp.setManagerName(manager.getEmployeeFirstName() + " " + manager.getEmployeeLastName());
		}

		List<Integer> employeeIdsInActive = new ArrayList<Integer>();

		List<Employee> listInactiveEmp = service.getAllInactiveEmployee();
		for (Employee emp : listInactiveEmp) {
			System.out.println(emp);
			employeeIdsInActive.add((Integer.parseInt(emp.getManagerId())));
			Employee manager = (service.getEmployee(Integer.parseInt(emp.getManagerId())));
			emp.setManagerName(manager.getEmployeeFirstName() + " " + manager.getEmployeeLastName());
		}
		model.addObject("listInactiveEmp", listInactiveEmp);

		model.setViewName("adminhome");
		return model;
	}

}
