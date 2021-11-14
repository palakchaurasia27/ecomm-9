package com.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.entity.User;
import com.webservice.exceptions.InvalidUserException;
import com.webservice.exceptions.UserNotFoundException;
import com.webservice.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
public class UserController {

	@Autowired
	UserRepository uRepo;

	// list all users
	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> list = uRepo.findAll();
		if (!list.isEmpty()) {
			return list;
		}
		throw new UserNotFoundException("User list is empty !");
	}

	// get one user
	@GetMapping("/users/{id}")
	public User getUsers(@PathVariable("id") long id) {
		User fetchedUser = uRepo.findById(id).orElseThrow(() -> {
			throw new UserNotFoundException("User does not exist with id " + id);
		});
		return fetchedUser;
	}

	// create user
	@PostMapping("/users")
	public User addUser(@RequestBody(required=false) User userObj) {
		if(userObj !=null) {
			return uRepo.save(userObj);
		}
		throw new InvalidUserException("User creation failed ! missing user object !");
	}

	// update user
	@PutMapping("/users")
	public User updateUser(@RequestBody User userObj) {
		// step 1: find product
		User fetchedUser = uRepo.findById(userObj.getUserId()).orElseThrow(() -> {
			throw new UserNotFoundException("User does not exist with id " + userObj.getUserId());
		});
		// step 2: Map updating fields
		fetchedUser.setUserName(userObj.getUserName());
		fetchedUser.setUserEmail(userObj.getUserEmail());
		fetchedUser.setUserPwd(userObj.getUserPwd());
		fetchedUser.setUserRole(userObj.getUserRole());
		// step 3: update
		return uRepo.save(fetchedUser);

	}

	// delete one user
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		// step 1: find product
		User fetchedUser = uRepo.findById(id).orElseThrow(() -> {
			throw new UserNotFoundException("User does not exist with id " + id);
		});
		// step 2: delete
		uRepo.delete(fetchedUser);
	}
}