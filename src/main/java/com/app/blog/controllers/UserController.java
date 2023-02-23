package com.app.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.blog.entities.User;
import com.app.blog.exceptions.ResourceNotFoundException;
import com.app.blog.services.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/")
	public ResponseEntity<User> createUser(@Valid @RequestBody User u) {

		User newUser = userServiceImpl.createUser(u);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) throws ResourceNotFoundException {

		User u = userServiceImpl.getUserById(userId);
		return new ResponseEntity<User>(u, HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUsers() {

		return ResponseEntity.ok(userServiceImpl.getAllUsers());
	}

	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User u, @PathVariable int userId)
			throws ResourceNotFoundException {

		User updatedUser = userServiceImpl.updateUser(u, userId);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable int userId) throws ResourceNotFoundException {

		User deletedUser = userServiceImpl.deleteUserById(userId);
		return ResponseEntity.ok(deletedUser);
	}

}
