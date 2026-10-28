package com.example.redis.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.redis.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{
	
	EmployeeEntity findByUuid(UUID id);

}
