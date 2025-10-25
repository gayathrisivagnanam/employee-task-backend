package com.employee.restapi_crud.controller;

import java.util.Date;

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
import com.employee.restapi_crud.entity.Task;
import com.employee.restapi_crud.service.TaskService;

@RestController
@RequestMapping("/api/v1")
public class TaskController {
	@Autowired
	TaskService service;
	
	
   @PostMapping("/tasks")
   @ResponseStatus(value = HttpStatus.CREATED)
   public ResponseDTO save(@RequestBody Task task) {
	   return service.save(task);
   }
	
	
   @GetMapping("/task")
   public ResponseDTO fecthAll() {
	   return service.fecthAll();
   }
   
   @GetMapping("/task/{id}")
   public ResponseDTO fetchById(@PathVariable Integer id) {
	   return service.fetchById(id);
   }
   
   @GetMapping("/task/{assigned_to}")
   public ResponseDTO fetchByEmp(@PathVariable Integer empid) {
	   return service.fetchByEmp(empid);
   }
   
   @GetMapping("/task/{date}")
   public ResponseDTO fetchByDate(@PathVariable Date date) {
	   return service.fetchByDate(date);
   }
   
   @PutMapping("/task/{id}")
   public ResponseDTO updateCompletely(@PathVariable Integer empid,@RequestBody Task task) {
	   return service.UpdateComplete(empid,task);
   }
   @PatchMapping("/task/{id}")
   public ResponseDTO updatePartially(@PathVariable Integer empid,@RequestBody Task task) {
	   return service.UpdatePartilly(empid,task);
   }
   @DeleteMapping("/task/{id}")
   public void deleteById(@PathVariable Integer id) {
	    service.deleteById(id);
   }
}
