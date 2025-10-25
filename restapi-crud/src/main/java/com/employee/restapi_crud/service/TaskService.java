package com.employee.restapi_crud.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.restapi_crud.dto.ResponseDTO;
import com.employee.restapi_crud.entity.Task;
import com.employee.restapi_crud.exception.DataNotFoundException;
import com.employee.restapi_crud.repository.TaskRepository;
@Service
public class TaskService {
	@Autowired
	TaskRepository repository;

	public ResponseDTO fecthAll() {
		List<Task> tasks=repository.findAll();
		return new ResponseDTO("Data Found",tasks);
	}

	public ResponseDTO fetchById(Integer id) {
		
		Task task=repository.findById(id).orElseThrow(()-> new DataNotFoundException("No task found with id"+id));
		return new ResponseDTO("Data Found",task);
		
	}

	public ResponseDTO save(Task task) {
		repository.save(task);
		return new ResponseDTO("Task Added Successfully",task);
	}

	public ResponseDTO fetchByEmp(Integer empid) {
		List<Task> tasks=repository.findByAssignedTo(empid);
		if(tasks.isEmpty()) {
			throw new DataNotFoundException("No task found with id"+empid);
		}
		return new ResponseDTO("Data Found",tasks);
	}
	
	public ResponseDTO fetchByDate(Date date) {
		List<Task> tasks=repository.findByDueDate(date);
		if(tasks.isEmpty()) {
			throw new DataNotFoundException("No task found with duedate"+date);
		}
		return new ResponseDTO("Data Found",tasks);
	}
	public ResponseDTO fetchBystatus(String status) {
		List<Task> tasks=repository.findByStatus(status);
		if(tasks.isEmpty()) {
			throw new DataNotFoundException("No task found "+status);
		}
		return new ResponseDTO("Data Found",tasks);
	}
	public ResponseDTO UpdateComplete(Integer id,Task task) {
		repository.findById(id).orElseThrow(()->new DataNotFoundException("No task found with id"+id));
		task.setId(id);
		repository.save(task);
		return new ResponseDTO("Updated Successfully",task);
	}
	
	public ResponseDTO UpdatePartilly(Integer id,Task task) {
		Task exist=repository.findById(id).orElseThrow(()->new DataNotFoundException("No task found with id"+id));
		exist.setTask(task.getTask()==null?exist.getTask():task.getTask());
		exist.setAssignedTo(task.getAssignedTo()==null?exist.getAssignedTo():task.getAssignedTo());
		exist.setDueDate(task.getDueDate()==null?exist.getDueDate():task.getDueDate());
		exist.setStatus(task.getStatus()==null?exist.getStatus():task.getStatus());
		repository.save(exist);
		return new ResponseDTO("Updated Successfully",exist);
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}
