package com.portfolio.chakru.service;

import java.util.List;
import java.util.Optional;

import com.portfolio.chakru.models.UserModel;

public interface UserService {

	void deleteUserModelById(Long id);

	UserModel findUserModelById(Long id);

	UserModel updateUser(UserModel userModel);

	UserModel addUser(UserModel userModel);

	List<UserModel> findAllUsers();
	
}
