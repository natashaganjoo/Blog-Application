package com.app.blog.services;

import java.util.List;

import com.app.blog.entities.User;
import com.app.blog.exceptions.ResourceNotFoundException;

public interface IUserService {

	User createUser(User u);

	List<User> getAllUsers();

	User getUserById(int userId) throws ResourceNotFoundException;

	User updateUser(User u, int userId) throws ResourceNotFoundException;

	User deleteUserById(int userId) throws ResourceNotFoundException;
}
