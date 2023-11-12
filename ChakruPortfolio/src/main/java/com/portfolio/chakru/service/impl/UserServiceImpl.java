package com.portfolio.chakru.service.impl;

import com.portfolio.chakru.exceptions.UserNotFoundException;
import com.portfolio.chakru.models.UserGroupModel;
import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.repo.UserGroupsRepo;
import com.portfolio.chakru.repo.UserRepo;
import com.portfolio.chakru.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService/*, UserDetailsService */{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserGroupsRepo userGroupRepo;

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
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
	}

	public UserModel findUserModelByUsername(String username) {
		
		if(userRepo.findUserModelByUsername(username)!=null) {
			return userRepo.findUserModelByUsername(username);
		}
		else {
			throw new UserNotFoundException("User with ID " + username + " not found.");
		}
				
	}
	
	@Override
	public List<UserModel> findUserModelByUserGroup(String usergroup) {
		return userRepo.findUserModelByUserGroup(usergroup);
	}

	@Override
	public void assignRoleToUser(String username, String usergroup) {
		//userRepo.setUserGroupforUserModel(usergroup, username);
		UserModel user = userRepo.findUserModelByUsername(username);
		UserGroupModel usergroups = userGroupRepo.findUserGroupModelByName(usergroup);
	    user.getUserGroup().add(usergroups);
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UserModel usermodel = userRepo.findUserModelByUsername(username);
//		if (usermodel == null) {
//			throw new UserNotFoundException("User with ID " + username + " not found.");
//		}
//
//		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//		usermodel.getUserGroup().forEach(t -> new SimpleGrantedAuthority(t.getName()));
//		return new User(usermodel.getUsername(), usermodel.getPassword(), authorities);
//	}

}
