package com.app.blog.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.entities.User;
import com.app.blog.exceptions.ResourceNotFoundException;
import com.app.blog.repositories.UserRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User u) {
		User newUser = userRepo.save(u);

		return newUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<>();

		allUsers = userRepo.findAll();
		return allUsers;
	}

	@Override
	public User getUserById(int userId) throws ResourceNotFoundException {

		User u = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return u;
	}

	@Override
	public User updateUser(User user, int userId) throws ResourceNotFoundException {

		User u = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		u.setUsername(user.getUsername());
		u.setEmail(user.getEmail());
		u.setAbout(user.getAbout());
		u.setPassword(user.getPassword());

		User updatedUser = userRepo.save(u);
		return updatedUser;

	}

	@Override
	public User deleteUserById(int id) throws ResourceNotFoundException {
		User u = getUserById(id);
		userRepo.delete(u);
		return null;
	}

}
