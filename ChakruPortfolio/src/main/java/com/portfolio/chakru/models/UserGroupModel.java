package com.portfolio.chakru.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupModel {

	@Id
	@Column	(nullable = false , updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(unique=true)
	private String name;
}
