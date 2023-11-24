package net.project2.springbootrestfulwebservices.service;

import java.util.List;

import net.project2.springbootrestfulwebservices.dto.UserDto;
import net.project2.springbootrestfulwebservices.entity.User;

public interface UserService {

	UserDto createUser(UserDto user);

	UserDto getUserById(Long userId);

	List<UserDto> getAllUsers();

	UserDto updateUser(UserDto user);
	
	void deleteUser(Long userId);
}
