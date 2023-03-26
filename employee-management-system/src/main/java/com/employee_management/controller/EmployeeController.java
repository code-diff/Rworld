package com.employee_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.employee_management.dto.Employee;
import com.employee_management.service.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;

	
	@GetMapping("/home")
	public String getAll(Model model) 
	{
		model.addAttribute("employees",employeeService.getAllEmployees() );
		return "employees";
		
	}
	@GetMapping("/create_employee")
	public String createEmployee(Model model) 
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "addemployee";
	
	}
	@PostMapping("/newemployee")
	public String saveEmployee(@ModelAttribute("employee")Employee emp) 
	{
		employeeService.save(emp);
		return "redirect:/home";
	}
	
	@GetMapping("/employee/edit/{id}")
	private String updateEmployee(@PathVariable int id,Model model) 
	{
		model.addAttribute("existing_employee", employeeService.getEmployeeById(id));
		return "editemployee";
		
	}
	
	@PostMapping("/updateemployee/{id}")
	public String updateEmployee(@ModelAttribute("existing_employee")Employee emp,@PathVariable int id) 
	{
		emp.setId(id);
		employeeService.save(emp);
		return "redirect:/home";
	}
	
	@GetMapping("/employee/delete/{id}")
	public String deleteEmployee(@PathVariable int id) 
	{
		employeeService.delete(id);
		return "redirect:/home";
		
	}
	@GetMapping("/search")
	public String search(@RequestParam(value = "name") String name,Model model) 
	{
		model.addAttribute("searchedemployee", employeeService.searchByName(name));
		return "searchresult";
		
	}

}
