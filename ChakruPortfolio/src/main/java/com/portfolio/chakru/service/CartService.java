package com.portfolio.chakru.service;

import com.portfolio.chakru.models.CartModel;
import com.portfolio.chakru.models.ProductModel;
import com.portfolio.chakru.models.UserModel;


public interface CartService {

	CartModel addToCart(ProductModel productModel , UserModel user, int quantity);
	
	CartModel removeFromCart(ProductModel productModel, UserModel user);

	void clearCart(UserModel userModel);
	
}
