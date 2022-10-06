package com.portfolio.chakru.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;


	@GetMapping("/all")
	public ResponseEntity<List<UserModel>> getAllUsers() {
		List<UserModel> users = userService.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<UserModel> getUserById(@PathVariable("id") Long id) {
		UserModel user = userService.findUserModelById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) {
		UserModel newUserModel = userService.addUser(userModel);
		return new ResponseEntity<>(newUserModel, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<UserModel> updateUsers(@RequestBody UserModel userModel) {
		UserModel updateUser = userService.updateUser(userModel);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		userService.deleteUserModelById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
