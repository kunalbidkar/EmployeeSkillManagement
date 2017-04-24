package com.xp.employee.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xp.employee.model.Employee;
import com.xp.employee.service.ManagerService;

/**
 * 
 * @author bimalbhaid All spring security related controllers.
 */
@Controller
public class SecurityController {

	@Autowired
	ManagerService managerService;

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/admin/employee", method = RequestMethod.GET)
	public ModelAndView employeePage(HttpServletRequest request, HttpServletResponse responce,
			Authentication authentication) {

		ModelAndView model = new ModelAndView();
		setLoggedinUserinSessionAttribute(authentication.getName(), request);
		
		model.setViewName("addEmployee");

		return model;

	}

	@RequestMapping(value = "/manager/managerHome", method = RequestMethod.GET)
	public ModelAndView mangerHome(HttpServletRequest request, HttpServletResponse responce,
			Authentication authentication) {

		ModelAndView model = new ModelAndView();

		setLoggedinUserinSessionAttribute(authentication.getName(), request);

		String username = authentication.getName();
		

		model.setViewName("managerHome");

		return model;

	}

	private void setLoggedinUserinSessionAttribute(String username, HttpServletRequest request) {
		Employee secureUser = managerService.getSecureuserObject(username);
		
		HttpSession session = request.getSession();
		session.setAttribute("secureUser", secureUser);

	}

	@RequestMapping(value = "/employee/employeeHome", method = RequestMethod.GET)
	public ModelAndView employeeHome(HttpServletRequest request, HttpServletResponse responce,
			Authentication authentication) {

		ModelAndView model = new ModelAndView();
		setLoggedinUserinSessionAttribute(authentication.getName(), request);
		
		model.setViewName("employeeHome");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		model.setViewName("login");

		return model;

	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}

}