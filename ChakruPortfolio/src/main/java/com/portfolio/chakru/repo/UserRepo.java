package com.portfolio.chakru.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.chakru.models.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Long>{
	
	List<UserModel> findUserModelByUserGroup(String usergroup);
	UserModel findUserModelByUsername(String username);
//	@Modifying
//	@Query("update user_Model ug set ug.user_group = ?1 where ug.username = ?2")
	//void setUserGroupforUserModel(String userGroup , String username);
}