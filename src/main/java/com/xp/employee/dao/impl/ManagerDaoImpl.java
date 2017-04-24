package com.xp.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xp.employee.dao.ManagerDao;
import com.xp.employee.model.Employee;
import com.xp.employee.model.EmployeeSkill;

/**
 * 
 * @author bimalbhaid
 *
 */
@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Employee> getEmployeeOfManager(int secureUserId) {

		String query = "SELECT * FROM employee WHERE employeeId IN (SELECT eId FROM employeemanager where managerId = '"
				+ secureUserId + "');";

		List<Employee> employeeList = jdbcTemplate.query(query, new RowMapper<Employee>() {
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

		return employeeList;
	}

	public Employee getSecureuserObject(String username) {

		String sql = "select * from employee where employeeEmail=?";

		return jdbcTemplate.queryForObject(sql, new Object[] { username },
				new BeanPropertyRowMapper<Employee>(Employee.class));

	}

	public List<EmployeeSkill> getAllPendingApprovals(Employee secureUser) {
		int mangerId = secureUser.getEmployeeId();

		String query = "SELECT * FROM employeeskills WHERE managerId =" + mangerId + " AND" + " status ='Pending'";

		List<EmployeeSkill> employeeSkillsList = jdbcTemplate.query(query, new RowMapper<EmployeeSkill>() {
			public EmployeeSkill mapRow(ResultSet rs, int row) throws SQLException {
				EmployeeSkill e = new EmployeeSkill();
				e.setApprovalId(rs.getInt(9));
				e.setEmpId(rs.getInt(1));
				e.setManagerId(rs.getInt(2));
				e.setSkillId(rs.getInt(3));
				e.setStatus(rs.getString(4));
				e.setComments(rs.getString(5));
				e.setSkillName(rs.getString(6));
				e.setEmployeeRating(rs.getInt(7));
				e.setManagerComments(rs.getString(8));

				return e;
			}
		});

		return employeeSkillsList;

	}

	public List<EmployeeSkill> getAllApprovedApprovals(Employee secureUser) {
		int mangerId = secureUser.getEmployeeId();

		String query = "SELECT * FROM employeeskills WHERE managerId =" + mangerId + " AND" + " status ='Approved'";

		List<EmployeeSkill> employeeSkillsList = jdbcTemplate.query(query, new RowMapper<EmployeeSkill>() {
			public EmployeeSkill mapRow(ResultSet rs, int row) throws SQLException {
				EmployeeSkill e = new EmployeeSkill();
				e.setApprovalId(rs.getInt(9));
				e.setEmpId(rs.getInt(1));
				e.setManagerId(rs.getInt(2));
				e.setSkillId(rs.getInt(3));
				e.setStatus(rs.getString(4));
				e.setComments(rs.getString(5));
				e.setSkillName(rs.getString(6));
				e.setEmployeeRating(rs.getInt(7));
				e.setManagerComments(rs.getString(8));

				return e;
			}
		});

		return employeeSkillsList;

	}

	public boolean approveEmpSkillRating(int empSkillId) {
		String query = "update employeeskills set status='" + "Approved" + "' where approvalId='" + empSkillId + "'";
		try {
			jdbcTemplate.update(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<EmployeeSkill> getAllRejectedApprovals(Employee secureUser) {
		int mangerId = secureUser.getEmployeeId();

		String query = "SELECT * FROM employeeskills WHERE managerId =" + mangerId + " AND" + " status ='Rejected'";

		List<EmployeeSkill> employeeSkillsList = jdbcTemplate.query(query, new RowMapper<EmployeeSkill>() {
			public EmployeeSkill mapRow(ResultSet rs, int row) throws SQLException {
				EmployeeSkill e = new EmployeeSkill();
				e.setApprovalId(rs.getInt(9));
				e.setEmpId(rs.getInt(1));
				e.setManagerId(rs.getInt(2));
				e.setSkillId(rs.getInt(3));
				e.setStatus(rs.getString(4));
				e.setComments(rs.getString(5));
				e.setSkillName(rs.getString(6));
				e.setEmployeeRating(rs.getInt(7));
				e.setManagerComments(rs.getString(8));

				return e;
			}
		});

		return employeeSkillsList;
	}

	public boolean rejectEmpSkillRating(int empSkillId) {
		String query = "update employeeskills set status='" + "Rejected" + "' where approvalId='" + empSkillId + "' ";
		try {
			jdbcTemplate.update(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
