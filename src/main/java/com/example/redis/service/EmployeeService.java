package com.example.redis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.redis.request.EmployeeRequest;
import com.example.redis.response.EmployeeResponse;

@Service
public interface EmployeeService {
	
	List<EmployeeResponse> getEmployeeList();

	EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

	
	EmployeeResponse getEmployeeById(String employeeId);

}
