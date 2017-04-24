package com.xp.employee.dao;

import java.util.List;

import com.xp.employee.model.Skill;

/**
 * @author Dnyaneshwar
 *
 */
public interface ManagerSkillDao {

	public int save(Skill s);

	public int update(Skill s);

	public int delete(int id);

	public Skill getSkillById(int id);

	public List<Skill> getSkills();

}
