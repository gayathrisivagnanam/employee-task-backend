package com.employee.restapi_crud.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.restapi_crud.entity.Employee;
import com.employee.restapi_crud.entity.Task;



public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	boolean existsByMobileOrEmail(Long mobile, String email);

	List<Employee> findByDepartment(String dept);

	

	

	
  
}
