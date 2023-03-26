package com.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee_management.dto.LoginForm;
import com.employee_management.dto.Employee;
import com.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	EmployeeRepository employeeRepository;
	

	public List<Employee> getAllEmployees() 
	{
		return employeeRepository.findAll();

	}

	public void save(Employee employee) {
		
		employeeRepository.save(employee);
		
	}
	public Employee getEmployeeById(int id) 
	{
		return employeeRepository.findById(id).get();
		
		
	}

	public void delete(int id) 
	{
		employeeRepository.deleteById(id);
		
	}

	public List<Employee> searchByName(String name) 
	{
		return employeeRepository.findByFname(name);
		
		
	}

	

}
