package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
	private Long userId;
	private String username;
	private String password;
	private String email;
	private String city;
	private long mobile;
}