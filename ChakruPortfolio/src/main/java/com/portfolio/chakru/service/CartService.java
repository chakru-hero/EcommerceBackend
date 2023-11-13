package com.portfolio.chakru.service;

import com.portfolio.chakru.models.CartModel;
import com.portfolio.chakru.models.UserModel;


public interface CartService {

	CartModel addToCart(String productCode , UserModel user, int quantity);
	
	CartModel removeFromCart(String productCode, UserModel user);

	void clearCart(UserModel userModel);
	
}
