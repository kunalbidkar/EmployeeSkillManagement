package com.xp.employee.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xp.employee.dao.*;
import com.xp.employee.model.*;
import com.xp.employee.service.ManagerSkillService;
/**
 * @author Dnyaneshwar
 *
 */
@Service
public class ManagerSkillServiceImpl implements ManagerSkillService {

	@Autowired
	ManagerSkillDao dao;

	public Skill saveskill(Skill s) {
		dao.save(s);
		return s;

	}

	public List<Skill> getAllSkill() {

		return dao.getSkills();

	}

	public void deleteSkill(int id) {

		dao.delete(id);

	}

	public Skill getSkillByID(int id) {
		return dao.getSkillById(id);

	}

	public void updateSkill(Skill s) {

		dao.update(s);

	}

}
