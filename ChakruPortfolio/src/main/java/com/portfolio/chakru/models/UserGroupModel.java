package com.portfolio.chakru.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserGroupModel {

	@Id
	@Column	(nullable = false , updatable = false)
	private String userGroupID;

	
	public String getUserGroupID() {
		return userGroupID;
	}

	public void setUserGroupID(String userGroupID) {
		this.userGroupID = userGroupID;
	}

}
