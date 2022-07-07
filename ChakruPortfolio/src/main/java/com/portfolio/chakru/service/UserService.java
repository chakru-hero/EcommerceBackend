package com.portfolio.chakru.service;

import java.util.List;

import com.portfolio.chakru.models.UserModel;

public interface UserService {

	void deleteUserModelById(Long id);

	UserModel findUserModelById(Long id);

	UserModel updateUser(UserModel userModel);

	UserModel addUser(UserModel userModel);

	List<UserModel> findAllUsers();
	
	List<UserModel> findUserModelByUserGroup (String usergroup);
	
	void assignRoleToUser(String username,String usergroup);
	
}
