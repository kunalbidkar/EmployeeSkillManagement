package com.xp.employee.service;

import java.util.List;
import com.xp.employee.model.Skill;
/**
 * @author Dnyaneshwar
 *
 */
public interface ManagerSkillService {

	public Skill saveskill(Skill s);

	public List<Skill> getAllSkill();

	public void deleteSkill(int id);

	public Skill getSkillByID(int id);

	public void updateSkill(Skill s);
}
