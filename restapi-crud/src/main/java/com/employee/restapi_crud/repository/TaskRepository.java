package com.employee.restapi_crud.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.restapi_crud.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	List<Task> findByAssignedTo(Integer empid);

	List<Task> findByDueDate(Date date);

	List<Task> findByStatus(String status);

}
