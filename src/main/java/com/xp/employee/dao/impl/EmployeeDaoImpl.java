package com.xp.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xp.employee.dao.EmployeeDao;
import com.xp.employee.model.Employee;
import com.xp.employee.model.EmployeeSkill;
import com.xp.employee.model.Skill;

/**
 * @author Madhav
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addEmployee(Employee e) {
		try {
			String query = "insert into employee (employeeFirstName,employeeLastName,employeeEmail,employeeMobNo,employeeAddress,employeeGender,employeeDOB,employeeDOJ,employeeStatus,role)"

					+ "values('" + e.getEmployeeFirstName() + "','" + e.getEmployeeLastName() + "','"
					+ e.getEmployeeEmail() + "','" + e.getEmployeeMobNo() + "','" + e.getEmployeeAddress() + "','"
					+ e.getEmployeeGender() + "','" + e.getEmployeeDOB() + "','" + e.getEmployeeDOJ() + "','"
					+ e.getEmployeeStatus() + "','" + e.getEmployeeRole() + "')";

			String userName = e.getEmployeeEmail();
			String password1 = e.getEmployeeFirstName().toLowerCase() + e.getEmployeeLastName().toLowerCase().charAt(0);
			String p2 = Long.toString(e.getEmployeeMobNo()).substring(5);
			password1 = password1 + p2;

			String sql = "insert into credentials values ('" +userName+ "','123',1)";

			jdbcTemplate.update(query);
			jdbcTemplate.update(sql);
			addEmployeeManager(e.getEmployeeEmail(), e.getManagerId());
			return 1;

		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}

	}

	private void addEmployeeManager(String employeeEmail, String managerId) {
		Employee employee = getEmployeeByEmail(employeeEmail);
		String mangerQuery = "insert into employeemanager values ('" + employee.getEmployeeId() + "','" + managerId
				+ "')";
		jdbcTemplate.update(mangerQuery);
	}

	public List<Employee> getAllEmployee() {

		return jdbcTemplate.query("select * from employee where employeeStatus='Active'", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt(1));
				e.setEmployeeFirstName(rs.getString(2));
				e.setEmployeeLastName(rs.getString(3));
				e.setEmployeeEmail(rs.getString(4));
				e.setEmployeeMobNo(rs.getLong(5));
				e.setEmployeeAddress(rs.getString(6));
				e.setEmployeeGender(rs.getString(7));
				e.setEmployeeDOB(rs.getString(8));
				e.setEmployeeDOJ(rs.getString(9));
				e.setEmployeeStatus(rs.getString(10));
				e.setEmployeeRole(rs.getString(11));
				e.setManagerId(getManagerIdByEmployeeId(e.getEmployeeId()));

				return e;
			}
		});
	}

	public String getManagerIdByEmployeeId(int empId) {
		String query = "select managerId from employeemanager where eid='" + empId + "'";
		String managerId = jdbcTemplate.queryForObject(query, new Object[] {}, String.class);
		return managerId;
	}

	public List<Employee> getAllInactiveEmployee() {

		String qry = "select * from employee where employeeStatus='Inactive'";
		return jdbcTemplate.query(qry, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt(1));
				e.setEmployeeFirstName(rs.getString(2));
				e.setEmployeeLastName(rs.getString(3));
				e.setEmployeeEmail(rs.getString(4));
				e.setEmployeeMobNo(rs.getLong(5));
				e.setEmployeeAddress(rs.getString(6));
				e.setEmployeeGender(rs.getString(7));
				e.setEmployeeDOB(rs.getString(8));
				e.setEmployeeDOJ(rs.getString(9));
				e.setEmployeeStatus(rs.getString(10));
				e.setEmployeeRole(rs.getString(11));
				e.setManagerId(getManagerIdByEmployeeId(e.getEmployeeId()));

				return e;
			}
		});
	}

	public int deleteEmployee(int eid) {
		String query = "update employee set employeeStatus = 'Inactive' where employeeId='" + eid + "' ";
		return jdbcTemplate.update(query);

	}

	@SuppressWarnings("unused")
	public int updateEmployee(Employee e) {

		String query = "update employee set employeeFirstName='" + e.getEmployeeFirstName() + "',employeeLastName='"
				+ e.getEmployeeLastName() + "',employeeEmail='" + e.getEmployeeEmail() + "',employeeMobNo='"
				+ e.getEmployeeMobNo() + "',employeeAddress='" + e.getEmployeeAddress() + "',employeeGender='"
				+ e.getEmployeeGender() + "',employeeDOB='" + e.getEmployeeDOB() + "',employeeDOJ='"
				+ e.getEmployeeDOJ() + "',employeeStatus='" + e.getEmployeeStatus() + "',role='" + e.getEmployeeRole()
				+ "' where employeeId='" + e.getEmployeeId() + "' ";

		Employee employee = getEmployeeByEmail(e.getEmployeeEmail());
		String mangerQuery = "update employeemanager set managerId = '" + e.getManagerId() + "'" + " where eid='"
				+ e.getEmployeeId() + "' ";
		jdbcTemplate.update(mangerQuery);

		return jdbcTemplate.update(query);
	}

	public Employee getEmployee(int eid) {

		String sql = "select * from employee where employeeId=?";

		return jdbcTemplate.queryForObject(sql, new Object[] { eid },
				new BeanPropertyRowMapper<Employee>(Employee.class));

	}

	public Employee getEmployeeByEmail(String email) {

		String sql = "select * from employee where employeeEmail=?";

		return jdbcTemplate.queryForObject(sql, new Object[] { email },
				new BeanPropertyRowMapper<Employee>(Employee.class));

	}

	public List<Employee> getAllManagers() {
		String qry = "select * from employee where role='ROLE_MANAGER'";
		return jdbcTemplate.query(qry, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setEmployeeId(rs.getInt(1));
				e.setEmployeeFirstName(rs.getString(2));
				e.setEmployeeLastName(rs.getString(3));
				e.setEmployeeEmail(rs.getString(4));
				e.setEmployeeMobNo(rs.getLong(5));
				e.setEmployeeAddress(rs.getString(6));
				e.setEmployeeGender(rs.getString(7));
				e.setEmployeeDOB(rs.getString(8));
				e.setEmployeeDOJ(rs.getString(9));
				e.setEmployeeStatus(rs.getString(10));
				e.setEmployeeRole(rs.getString(11));

				return e;
			}
		});

	}

	public Employee getEmployeeCurrentManager(int id) {

		String sql = " select e.employeeId,e.employeeFirstName,e.employeeLastName from employee e where e.employeeId IN(select managerId from employeemanager m,employee e where m.eid=e.employeeId and e.employeeId=?)";
		System.out.println(sql);

		return jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Employee>(Employee.class));

	}

	public List<Employee> getOtherManager(int id) {

		String sql = " select e.employeeId,e.employeeFirstName,e.employeeLastName from employee e where e.role='ROLE_MANAGER' and e.employeeId NOT IN(select managerId from employeemanager m,employee e where m.eid=e.employeeId and e.employeeId = "
				+ id + ")";

		return jdbcTemplate.query(sql, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();

				e.setEmployeeId(rs.getInt(1));
				e.setEmployeeFirstName(rs.getString(2));
				e.setEmployeeLastName(rs.getString(3));
				return e;
			}
		});

	}

}
