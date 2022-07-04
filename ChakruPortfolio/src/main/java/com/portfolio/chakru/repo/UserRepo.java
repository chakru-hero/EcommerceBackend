package com.portfolio.chakru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.chakru.models.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Long>{
	
}