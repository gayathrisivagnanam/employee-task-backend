package com.employee.restapi_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.employee.restapi_crud.dto.ResponseDTO;
import com.employee.restapi_crud.entity.Employee;
import com.employee.restapi_crud.exception.DataExistsException;
import com.employee.restapi_crud.exception.DataNotFoundException;
import com.employee.restapi_crud.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	
	public ResponseDTO save(Employee employee) {
	if(repository.existsByMobileOrEmail(employee.getMobile(),employee.getEmail())) {
		throw new DataExistsException("Email Already Exists");
	}
     repository.save(employee);
     return new ResponseDTO ("data Added Scucess",employee);
}
	
	
	public ResponseDTO fetchAll() {
		List<Employee> employees=repository.findAll();
    	if(employees.isEmpty()) {
    		throw new DataNotFoundException("No Data Present");
    	}
    	return new ResponseDTO("Data Found", employees);
	}
	
	public ResponseDTO fetchById(Integer id) {
		Employee employee = repository.findById(id).orElseThrow(()-> new DataNotFoundException("No Record Found with Id"+id));
		return  new ResponseDTO("Data found",employee);
	}
	
	public ResponseDTO fetchByDept(String dept) {
		List<Employee> employees = repository.findByDepartment(dept);
		if(employees.isEmpty()) {
			throw new DataNotFoundException("No Record Found with dept"+dept) ;
		}
		return  new ResponseDTO("Data found",employees);
	}




	

	public ResponseDTO updateCompletely(Integer id, Employee employee){
	      repository.findById(id).orElseThrow(() -> new RuntimeException(" No Employee found with id " + id));
	      employee.setId(id);
	       repository.save(employee);

	    return  new ResponseDTO("Data Updated successfully",employee);
	}


	public ResponseDTO updatePartially(Integer id, Employee employee) {
		 Employee exist=repository.findById(id).orElseThrow(() -> new RuntimeException("No Employee found with id " + id));
	      exist.setName(employee.getName()==null?exist.getName():employee.getName());
	      exist.setEmail(employee.getEmail()==null?exist.getEmail():employee.getEmail());
	      exist.setMobile(employee.getMobile()==null?exist.getMobile():employee.getMobile());
	      exist.setSal(employee.getSal()==null?exist.getSal():employee.getSal());
	      exist.setDepartment(employee.getDepartment()==null?exist.getDepartment():employee.getDepartment());
	      repository.save(exist);
	      return  new ResponseDTO("Data Updated successfully",exist);
	}


	public void deleteById(Integer id) {
		repository.findById(id).orElseThrow(() -> new RuntimeException("No Employee found with id " + id));
		repository.deleteById(id);
		
	}
	}

