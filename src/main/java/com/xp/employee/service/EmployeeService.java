/**
 * 
 */
package com.xp.employee.service;

import java.util.List;

import com.xp.employee.model.Employee;

/**
 * @author Madhav
 *
 */
public interface EmployeeService {
	public int addEmployee(Employee e);

	public List<Employee> getAllEmployee();

	public int deleteEmployee(int eid);

	public int updateEmployee(Employee employee);

	public Employee getEmployee(int employee);

	List<Employee> getAllInactiveEmployee();

	public List<Employee> getAllManagers();

	public Employee getEmployeeCurrentManager(int employeeId);

	public List getOtherManager(int employeeId);
}
