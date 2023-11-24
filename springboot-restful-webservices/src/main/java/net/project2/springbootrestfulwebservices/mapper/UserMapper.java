package net.project2.springbootrestfulwebservices.mapper;

import net.project2.springbootrestfulwebservices.dto.UserDto;
import net.project2.springbootrestfulwebservices.entity.User;

public class UserMapper {

	// Convert User JPA Entity
	public static UserDto mapToUserDto(User user) {
		UserDto userDto = new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
		return userDto;
	}

	// convert user dto into user JPA entity
	public static User mapToUser(UserDto userDto) {
		User user = new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
		return user;
	}

}
