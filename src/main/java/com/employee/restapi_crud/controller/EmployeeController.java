package com.employee.restapi_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.restapi_crud.dto.ResponseDTO;
import com.employee.restapi_crud.entity.Employee;
import com.employee.restapi_crud.service.EmployeeService;



@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	
    @PostMapping("/employee")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseDTO save(@RequestBody Employee employee) {
    	return service.save(employee);
    }
    
    
    @GetMapping("/employee")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseDTO fetchAll() {
    	return service.fetchAll();
    }
    
    @GetMapping("/employee/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseDTO fetchById(@PathVariable Integer id) {
    	return service.fetchById(id);
    }
   
    
    @GetMapping("/employee/dept/{dept}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseDTO fetchByDept(@PathVariable String dept) {
    	return service.fetchByDept(dept);
    }
    
    @PutMapping("employee/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseDTO updateCompletely(@PathVariable Integer id, @RequestBody Employee employee) {
        return service.updateCompletely(id, employee); 
    }
    
    @PatchMapping("employee/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseDTO updatePartially(@PathVariable Integer id, @RequestBody Employee employee) {
        return service.updatePartially(id, employee); 
    }
    
    @DeleteMapping("employee/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteById(@PathVariable Integer id) {
    	service.deleteById(id);
    }
    
    
    
}
