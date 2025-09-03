package com.productapp.service;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.productapp.model.User;
import com.productapp.model.UserDto;
import com.productapp.repository.IUserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

	private final IUserRepository userRepository;
	private final ModelMapper mapper;

	@Override
	public UserDto addUser(UserDto userDto) {
		User newUser = userRepository.save(mapper.map(userDto, User.class));
		return mapper.map(newUser, UserDto.class);
	}

	@Override
	public UserDto getById(long userId) {
		User user = userRepository.findById(userId).get();
		return mapper.map(user, UserDto.class);
	}

	// put mapping
	@Override
	public UserDto updateUser(long userId, UserDto userDto) {
		// get the user from the db using the id or else throw exception
		User existingUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("invalid id"));

		// populata the user object properties from the dto object properties
		existingUser.setCity(userDto.getCity());
		existingUser.setEmail(userDto.getEmail());
		existingUser.setMobile(userDto.getMobile());
		existingUser.setPassword(userDto.getPassword());
		// call save method of repo
		User updatedUser = userRepository.save(existingUser);
		return mapper.map(updatedUser, UserDto.class);
	}

	// patch mapping
	@Override
	public UserDto updateUserProps(long userId, Map<String, Object> updates) {
		// get the user from the db using the id or else throw exception
		User existingUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("invalid id"));
		// iterate thru the map - updates
		updates.forEach((key,value)->{
			// use switch to check the property
			switch(key) {
			case "email":
				//set the updated mail value to the user object
				existingUser.setEmail((String)value);
				break;
			case "city":
				existingUser.setCity((String)value);
				break;
			case "mobile":
				//set the updated mobile value to the user object
				existingUser.setMobile((Long)value);
				break;
			case "password":
				existingUser.setPassword((String)value);
				break;
			default:
				throw new IllegalArgumentException("invalid field "+key);
			}
		});
		// call save method of repo
		User updatedUser = userRepository.save(existingUser);
		return mapper.map(updatedUser, UserDto.class);
	}
}



