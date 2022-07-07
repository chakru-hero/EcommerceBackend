package com.portfolio.chakru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.chakru.models.UserGroupModel;

public interface UserGroupsRepo extends JpaRepository<UserGroupModel, String> {

	UserGroupModel findUserGroupModelByName(String name);
}
