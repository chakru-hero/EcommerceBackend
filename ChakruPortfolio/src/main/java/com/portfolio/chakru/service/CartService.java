package com.portfolio.chakru.service;

import com.portfolio.chakru.models.ProductModel;
import com.portfolio.chakru.models.UserModel;


public interface CartService {

	void addToCart(ProductModel productModel , UserModel user);
	
	void removeFromCart(ProductModel productModel, UserModel user);

	void clearCart(UserModel userModel);
	
}
