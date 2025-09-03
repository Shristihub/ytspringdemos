package com.productapp.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.UserDto;
import com.productapp.service.IUserService;

@RestController
@RequestMapping("/user-api/v1")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/users")
	ResponseEntity<UserDto> addUser(@RequestBody UserDto userdto) {
		return ResponseEntity.ok(userService.addUser(userdto));
	}
	
	@GetMapping("/users/userId/{userId}")
	ResponseEntity<UserDto> getById(@PathVariable  long userId) {
		return ResponseEntity.ok(userService.getById(userId));
		
	}
	@PutMapping("/users/{userId}")
	ResponseEntity<UserDto> updateUser(@PathVariable long userId, @RequestBody UserDto userdto) {
		return ResponseEntity.ok(userService.updateUser(userId, userdto));
	}
	
	@PatchMapping("/users/{userId}")
	ResponseEntity<UserDto> patchUser(@PathVariable long userId, 
			@RequestBody Map<String,Object> map) {
		return ResponseEntity.ok(userService.updateUserProps(userId, map));
	}
}



