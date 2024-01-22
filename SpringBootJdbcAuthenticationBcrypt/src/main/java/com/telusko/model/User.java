package com.telusko.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private BigDecimal ID;
	private String USERNAME;
	private String PASSWORD;
    private String EMAIL;
    private Boolean ACCOUNT_ENABLED;

	
}
