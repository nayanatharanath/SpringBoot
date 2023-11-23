package net.project2.springbootrestfulwebservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.project2.springbootrestfulwebservices.entity.User;
import net.project2.springbootrestfulwebservices.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	@Override
	public User createUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserById(Long userId) {
		Optional<User> optionalUser = userRepo.findById(userId);
		return optionalUser.get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepo.findById(user.getId()).get();
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepo.save(existingUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);
	}

}
