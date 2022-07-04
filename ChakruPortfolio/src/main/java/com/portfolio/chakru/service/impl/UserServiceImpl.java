package com.portfolio.chakru.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.chakru.exceptions.UserNotFoundException;
import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.repo.UserRepo;
import com.portfolio.chakru.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserModel addUser(UserModel userModel) {
		return userRepo.save(userModel);

	}

	@Override
	public List<UserModel> findAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public UserModel updateUser(UserModel userModel) {
		return userRepo.save(userModel);
	}

	@Override
	public void deleteUserModelById(Long id) {
		userRepo.deleteById(id);

	}

	public UserModel findUserModelById(Long id) {
		return userRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
	}
	
}
