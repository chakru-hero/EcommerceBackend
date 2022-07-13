package com.portfolio.chakru.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartModel {

	@Id
	@Column	(nullable = false , updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToMany
	private Collection<ProductModel> products;
	@OneToOne(targetEntity=UserModel.class, fetch=FetchType.EAGER)
	private UserModel user;

	
	
	public Collection<ProductModel> getProducts() {
		return products;
	}
	public void setProducts(Collection<ProductModel> products) {
		this.products = products;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	
	
}
