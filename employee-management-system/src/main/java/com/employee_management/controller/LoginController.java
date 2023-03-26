package com.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee_management.dto.LoginForm;
import com.employee_management.service.LoginService;


@Controller
public class LoginController 
{
	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public String createEmployee() 
	{
		return "login";
	
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute("logininfo")LoginForm logininfo)
	{
		boolean islogin=loginService.loginCheck(logininfo);
		if (islogin) 
		{
			return "redirect:/home";
		}
		else {
			return "redirect:/login";
		}
	}

}
