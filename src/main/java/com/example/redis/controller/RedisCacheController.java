package com.example.redis.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.response.EmployeeResponse;
import com.example.redis.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class RedisCacheController {
	
	private final EmployeeService employeeService;

	public RedisCacheController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeResponse>> getEmployeeList() {

		return ResponseEntity.ok(employeeService.getEmployeeList());
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable(name = "id") String employeeId) {

		return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
	}

}
