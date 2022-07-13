package com.portfolio.chakru.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.chakru.models.CartModel;
import com.portfolio.chakru.models.ProductModel;
import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.repo.CartRepo;
import com.portfolio.chakru.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private CartModel cartModel;

	@Override
	public void addToCart(ProductModel productModel, UserModel user) {
		if(cartRepo.findCartModelByUser(user)==null) {
			CartModel newCart = createCart(productModel,user);
		cartRepo.save(newCart);
		}
		else {
			
			CartModel existingcart = cartRepo.findCartModelByUser(user);
			Collection<ProductModel> products = existingcart.getProducts();
			products.add(productModel);
			existingcart.setProducts(products);
			cartRepo.save(existingcart);
		}
	}

	@Override
	public void removeFromCart(ProductModel productModel, UserModel user) {
		CartModel existingcart =  cartRepo.findCartModelByUser(user);
		Collection<ProductModel> products = existingcart.getProducts();
		products.remove(productModel);
		existingcart.setProducts(products);
		cartRepo.save(existingcart);
	}

	
	public CartModel createCart(ProductModel productModel, UserModel user) {
		
		Collection<ProductModel> products = new ArrayList<>();
		products.add(productModel);
	    cartModel.setProducts(products);
		cartModel.setUser(user);
		return cartModel;
	}
}
