package net.project2.springbootrestfulwebservices.service;

import java.util.List;

import net.project2.springbootrestfulwebservices.entity.User;

public interface UserService {

	User createUser(User user);

	User getUserById(Long userId);

	List<User> getAllUsers();

	User updateUser(User user);
	
	void deleteUser(Long userId);
}
