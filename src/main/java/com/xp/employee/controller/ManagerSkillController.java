package com.xp.employee.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xp.employee.model.Skill;
import com.xp.employee.service.ManagerSkillService;
import com.xp.employee.service.impl.ManagerSkillServiceImpl;

/**
 * @author Dnyaneshwar
 *
 */
@Controller
public class ManagerSkillController {

	@Autowired
	ManagerSkillService service;
	Skill skill;
	
	@RequestMapping("/manager/addskill")
	public ModelAndView addskill() {
		return new ModelAndView("addskill", "command", new Skill());
	}

	@RequestMapping(value = "/manager/save", method = RequestMethod.POST)
	public ModelAndView save(Skill skill) {
		service.saveskill(skill);
		return new ModelAndView("redirect:/manager/viewskill");
	}

	@RequestMapping(value = "/manager/viewskill")
	public ModelAndView viewskill() {
		List<Skill> list = service.getAllSkill();
		return new ModelAndView("viewskill", "skillList", list);
	}

	@RequestMapping(value = "/manager/deleteskill", method = RequestMethod.GET)
	public ModelAndView deleteskill(HttpServletRequest request) {

		service.deleteSkill(Integer.parseInt(request.getParameter("id")));
		return new ModelAndView("redirect:/manager/viewskill");
	}

	@RequestMapping(value = "/manager/editTemp")
	public ModelAndView editskill(HttpServletRequest request) {

		skill = service.getSkillByID(Integer.parseInt(request.getParameter("id")));
		return new ModelAndView("editskill", "command", skill);
	}

	@RequestMapping(value = "/manager/editsave", method = RequestMethod.POST)
	public ModelAndView editsave(HttpServletRequest request) {
		skill.setSkillName(request.getParameter("skillName"));
		service.updateSkill(skill);
		return new ModelAndView("redirect:/manager/viewskill");
	}
}
