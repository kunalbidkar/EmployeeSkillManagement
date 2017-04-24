package com.xp.employee.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.xp.employee.model.Skill;
import com.xp.employee.dao.ManagerSkillDao;
import com.xp.employee.dao.impl.*;

/**
 * @author Dnyaneshwar
 *
 */
@Repository
public class ManagerSkillDaoImpl implements ManagerSkillDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int save(Skill s) {
		try {
			String sql = "insert into skill(skillName) values('" + s.getSkillName() + "')";
			return jdbcTemplate.update(sql);
		} catch (Exception e) {
			return 0;
		}
	}

	public int update(Skill s) {
		try {
			String sql = "update skill set skillName='" + s.getSkillName() + "' where skillId=" + s.getSkillId() + "";
			return jdbcTemplate.update(sql);
		} catch (Exception e) {
			return 0;
		}

	}

	public int delete(int id) {
		String sql = "delete from skill where skillId=" + id + "";
		return jdbcTemplate.update(sql);
	}

	public Skill getSkillById(int id) {
		String sql = "select * from skill where skillId=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Skill>(Skill.class));
	}

	public List<Skill> getSkills() {
		return jdbcTemplate.query("select * from skill", new ResultSetExtractor<List<Skill>>() {
			public List<Skill> extractData(ResultSet rs) throws SQLException, DataAccessException {

				List<Skill> list = new ArrayList<Skill>();
				while (rs.next()) {
					Skill s = new Skill();
					s.setSkillId(rs.getInt(1));
					s.setSkillName(rs.getString(2));
					list.add(s);
				}
				return list;
			}
		});
	}

	/* List Extracted using RowMapper */
	/*
	 * public List<Skill> getSkills() { return template.query(
	 * "select * from skill", new RowMapper<Skill>() { public Skill
	 * mapRow(ResultSet rs, int row) throws SQLException { Skill s = new
	 * Skill(); s.setSkillId(rs.getInt(1)); s.setSkillName(rs.getString(2));
	 * return s; } }); }
	 */

}
