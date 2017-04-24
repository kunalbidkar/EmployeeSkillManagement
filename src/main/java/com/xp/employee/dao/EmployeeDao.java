/**
 * 
 */
package com.xp.employee.dao;

import java.util.List;
import com.xp.employee.model.Employee;

/**
 * @author Madhav
 *
 */
public interface EmployeeDao {

	public int addEmployee(Employee e);

	public List<Employee> getAllEmployee();

	public List<Employee> getAllInactiveEmployee();
	
	public int deleteEmployee(int eid);

	public int updateEmployee(Employee e);

	public Employee getEmployee(int employee);

	public List<Employee> getAllManagers();
	
	public Employee getEmployeeCurrentManager(int employeeId);
	
	@SuppressWarnings("rawtypes")
	public List getOtherManager(int employeeId);
}
