package com.example.redis.service.impl;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.redis.entity.EmployeeEntity;
import com.example.redis.repository.EmployeeRepository;
import com.example.redis.request.EmployeeRequest;
import com.example.redis.response.EmployeeResponse;
import com.example.redis.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<EmployeeResponse> getEmployeeList() {
		// TODO Auto-generated method stub

		return employeeRepository.findAll().stream().map(this::toResponse).toList();

	}

	private EmployeeResponse toResponse(EmployeeEntity employee) {
		return new EmployeeResponse(employee.getUuid().toString(), employee.getName(), employee.getEmail(),
				employee.getDepartment(), employee.getSalary(), employee.getActive(), employee.getCreatedOn(),
				employee.getModifiedOn());
	}

	@Override
	public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
		// TODO Auto-generated method stub

		OffsetDateTime currentDateTime = OffsetDateTime.now();
		EmployeeEntity employee = EmployeeEntity.builder().uuid(UUID.randomUUID()).name(employeeRequest.name())
				.email(employeeRequest.email()).department(employeeRequest.department())
				.salary(employeeRequest.salary()).active(employeeRequest.isActive()).createdOn(currentDateTime)
				.modifiedOn(currentDateTime).build();
		employee = employeeRepository.save(employee);

		return toResponse(employee);
	}

	@Override
	@Cacheable(value = "employees", key = "#uuid")
	public EmployeeResponse getEmployeeById(String uuid) {
		// TODO Auto-generated method stub
		log.info("Before database call:");
		return toResponse(employeeRepository.findByUuid(UUID.fromString(uuid)));
	}
}
