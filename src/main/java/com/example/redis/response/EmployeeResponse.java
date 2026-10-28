package com.example.redis.response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record EmployeeResponse(String id, String name, String email, String department, BigDecimal salary, Boolean isActive,
		OffsetDateTime createdOn, OffsetDateTime modifiedOn) {
}