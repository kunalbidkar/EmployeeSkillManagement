/**
 * 
 */
package com.xp.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xp.employee.dao.EmployeeDao;
import com.xp.employee.model.Employee;
import com.xp.employee.service.EmployeeService;

/**
 * @author Madhav
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	/* Removing override annotation */

	@Autowired
	EmployeeDao dao;

	public List<Employee> getAllEmployee() {

		return dao.getAllEmployee();
	}

	public List<Employee> getAllInactiveEmployee() {

		return dao.getAllInactiveEmployee();
	}

	public int deleteEmployee(int e) {

		return dao.deleteEmployee(e);
	}

	public int updateEmployee(Employee employee) {

		return dao.updateEmployee(employee);
	}

	public Employee getEmployee(int employee) {

		return dao.getEmployee(employee);
	}

	public int addEmployee(Employee e) {
		return dao.addEmployee(e);
	}

	public List<Employee> getAllManagers() {

		return dao.getAllManagers();
	}

	public Employee getEmployeeCurrentManager(int employeeId) {

		return dao.getEmployeeCurrentManager(employeeId);
	}

	public List getOtherManager(int employeeId) {

		return dao.getOtherManager(employeeId);
	}

}
