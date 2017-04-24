package com.xp.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xp.employee.dao.EmpSkillDao;
import com.xp.employee.model.Employee;
import com.xp.employee.model.EmployeeSkill;
import com.xp.employee.model.Skill;

/**
 * @author Madhav
 *
 */
@Repository
public class EmpSkillDaoImpl implements EmpSkillDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int addEmpSkill(EmployeeSkill e) {
		e.setManagerId(getManagerOfEmployee(e.getEmpId()).getEmployeeId());
		String sql = "insert into EmployeeSkills (empId,skillId,skillName,employeeRating,status,managerId) values (" + e.getEmpId() + ","
				+ e.getSkillId() + ",'"+ e.getSkillName() + "'," + e.getEmployeeRating() + ",'" + e.getStatus() + "','"+e.getManagerId()+"' )";
		try {
			return jdbcTemplate.update(sql);

		} catch (Exception e1) {
			e1.printStackTrace();
			return 0;
		}

	}
	
	public Employee getManagerOfEmployee(int mid){
		String sql = "select * from employee WHERE employeeId IN (SELECT managerId  FROM employeemanager where eId =?)";

		Employee emp =(Employee) jdbcTemplate.queryForObject(sql, new Object[] { mid },
				new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}
	


	/**
	 * Edited by Bimal
	 * Getting the skills of the particular Employee (Logged in user)
	 */
	public List<EmployeeSkill> getAllEmpSkills(Employee employee) {
		return jdbcTemplate.query("select * from EmployeeSkills where empId = '"+employee.getEmployeeId()+"'", new RowMapper<EmployeeSkill>() {
			public EmployeeSkill mapRow(ResultSet rs, int row) throws SQLException {
				EmployeeSkill e = new EmployeeSkill();
				e.setEmpId(rs.getInt(1));
				e.setManagerId(rs.getInt(2));
				e.setSkillId(rs.getInt(3));
				e.setStatus(rs.getString(4));
				e.setComments(rs.getString(5));
				e.setSkillName(rs.getString(6));
				e.setEmployeeRating(rs.getInt(7));
				e.setManagerComments(rs.getString(8));
				e.setApprovalId(rs.getInt(9));
				return e;
			}
		});
	}

	public int deleteEmpSkills(int eid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateEmpSkills(EmployeeSkill e, Employee employee) {

		String query = "update EmployeeSkills set skillId='" + e.getSkillId() +
				"', employeeRating='" + e.getEmployeeRating() + "',  skillName= '" + e.getSkillName() + "' where approvalId='" + e.getApprovalId() + "' ";
		
		System.out.println(query);
		return jdbcTemplate.update(query);
	}

	public EmployeeSkill getEmpSkills(int id) {
		String sql = "select * from EmployeeSkills where empId=?";

		return jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<EmployeeSkill>(EmployeeSkill.class));
	}

	
	public EmployeeSkill getCurrentEmpSkills(int id,int sid) {
		
		String sql = "select distinct s.skillId, s.skillName from skill s, EmployeeSkills e where s.skillId = e.skillId and e.empId = ? and e.skillId = "+sid+"";
		

		
		return jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<EmployeeSkill>(EmployeeSkill.class));
	}

	
	
	
	public List<Skill> getEmpSkillsExceptCurrent(int id,Employee employee) {

		String sql = "select distinct s.skillId, s.skillName from skill s, EmployeeSkills e where e.empId = "+employee.getEmployeeId()+" and s.skillName NOT IN(select s.skillName from skill s where s.skillId= "
				+ id + ")";
		
		
		return jdbcTemplate
				.query(sql, new RowMapper<Skill>() {
							public Skill mapRow(ResultSet rs, int row) throws SQLException {
								Skill e = new Skill();

								e.setSkillId(rs.getInt(1));

								e.setSkillName(rs.getString(2));

								return e;
							}
						});

	}

	public EmployeeSkill getSkillToBeEdit(int approvalId) {
		String sql = "select * from EmployeeSkills where approvalId=?";

		return jdbcTemplate.queryForObject(sql, new Object[] { approvalId },
				new BeanPropertyRowMapper<EmployeeSkill>(EmployeeSkill.class));
	}

	public int getSkillIdfromName(String skillName) {
		String sql = "select * from skill where skillName=?";
		Skill skill =  jdbcTemplate.queryForObject(sql, new Object[] { skillName }, new BeanPropertyRowMapper<Skill>(Skill.class));
		return skill.getSkillId();
	}

}
