package com.employee_management.service;

import org.springframework.stereotype.Service;

import com.employee_management.dto.LoginForm;

@Service
public class LoginService 
{

	public boolean loginCheck(LoginForm loginForm)
	{
		String username=loginForm.getUsername();
		String password=loginForm.getPassword();
		
		if ((username.equals("admin"))&&(password.equals("password"))) 
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	

}
