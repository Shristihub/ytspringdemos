package com.productapp.service;

import java.util.Map;

import com.productapp.model.UserDto;

public interface IUserService {

	UserDto addUser(UserDto userdto);
	UserDto getById(long userId);
	//put
	UserDto updateUser(long userId,UserDto userDto);
	// patch mapping
	UserDto updateUserProps(long userId,Map<String, Object> updates);
}
