package net.project2.springbootrestfulwebservices.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.project2.springbootrestfulwebservices.dto.UserDto;
import net.project2.springbootrestfulwebservices.entity.User;
import net.project2.springbootrestfulwebservices.exception.EmailAlreadyExistsException;
import net.project2.springbootrestfulwebservices.exception.ResourceNotFoundException;
import net.project2.springbootrestfulwebservices.mapper.AutoUserMapper;
// import net.project2.springbootrestfulwebservices.mapper.UserMapper;
import net.project2.springbootrestfulwebservices.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	// private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		// convert UserDTO into User JPA entity
		// User user = UserMapper.mapToUser(userDto);

		// User user = modelMapper.map(userDto, User.class);
		Optional<User> optionalUser = userRepo.findByEmail(userDto.getEmail());
		if (optionalUser.isPresent()) {
			throw new EmailAlreadyExistsException("Email already exists for user");
		}

		User user = AutoUserMapper.MAPPER.mapToUser(userDto);

		User savedUser = userRepo.save(user);

		// convert User JPA entity to UserDto
		// UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		// UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

		UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

		return savedUserDto;
	}

	@Override
	public UserDto getUserById(Long userId) {
		User optionalUser = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		// convert user entity into UserDto
		// User user = optionalUser.get();
		// return UserMapper.mapToUserDto(user);
		// return modelMapper.map(user, UserDto.class);
		return AutoUserMapper.MAPPER.mapToUserDto(optionalUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// convert user entity into UserDto
		List<User> users = userRepo.findAll();
		// return
		// users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
		// return users.stream().map((user) -> modelMapper.map(user,
		// UserDto.class)).collect(Collectors.toList());
		return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto user) {
		// User existingUser = userRepo.findById(user.getId()).get();
		User existingUser = userRepo.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepo.save(existingUser);
		// return UserMapper.mapToUserDto(updatedUser);
		// return modelMapper.map(updatedUser, UserDto.class);
		return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long userId) {
		User existingUser = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		userRepo.deleteById(userId);
	}

}
