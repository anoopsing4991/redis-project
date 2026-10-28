package com.example.redis.request;

import java.math.BigDecimal;

public record EmployeeRequest(

		String name, String email, String department, BigDecimal salary, Boolean isActive

) {

}
