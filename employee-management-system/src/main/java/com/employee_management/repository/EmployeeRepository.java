package com.employee_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee_management.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

//	@Query(value="select * from employee_list where first_name=?1",nativeQuery = true)
//	List<Employee> findByFname(String name);
	List<Employee> findByFname(String name);

}
