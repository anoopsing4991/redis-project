package com.example.redis.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "uuid")
	private UUID uuid;

	@Column(name = "email")
	private  String email;

	@Column(name = "department")
	private String department;

	@Column(name = "salary")
	private BigDecimal salary;

	@Column(name = "is_active")
	private Boolean active = true;

	@Column(name = "created_on", updatable = false)
	private OffsetDateTime createdOn;

	@Column(name = "modified_on")
	@LastModifiedDate
	private OffsetDateTime modifiedOn;
}