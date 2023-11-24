package net.project2.springbootrestfulwebservices.mapper;

import org.mapstruct.Mapper;
// import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import net.project2.springbootrestfulwebservices.dto.UserDto;
import net.project2.springbootrestfulwebservices.entity.User;

@Mapper
public interface AutoUserMapper {

	AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

	// The below annotation way is used, if the fields are defined differently in
	// both the classes
	// @Mapping(source = "email", target = "emailAddress")
	UserDto mapToUserDto(User user);

	User mapToUser(UserDto userDto);

}
