package com.portfolio.chakru.service.impl;

import com.portfolio.chakru.models.CartEntryModel;
import com.portfolio.chakru.models.CartModel;
import com.portfolio.chakru.models.ProductModel;
import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.repo.CartRepo;
import com.portfolio.chakru.service.CartService;
import com.portfolio.chakru.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepo cartRepo;
	@Autowired
	private ProductService productService;
	@Autowired
	private CartModel cartModel;

	@Override
	public CartModel addToCart(String productCode, UserModel user, int quantity) {
		ProductModel productModel = productService.findProductModelByCode(productCode);
		if(cartRepo.findCartModelByUser(user)==null) {
			CartModel newCart = createCart(productModel,user,quantity);
		cartRepo.save(newCart);
		return newCart;
		}
		else {
			
			CartModel existingcart = cartRepo.findCartModelByUser(user);
			boolean productExists = false;
			Collection<CartEntryModel> cartEntryCollection = existingcart.getCartEntry();
			for(CartEntryModel cartEntryModel : cartEntryCollection){
				if(cartEntryModel.getProduct() == productModel) {
					productExists = true;
					cartEntryModel.setQuantity(cartEntryModel.getQuantity() + quantity);
				}
			}
			if(!productExists){
				CartEntryModel cartEntryModel = new CartEntryModel();
				cartEntryModel.setProduct(productModel);
				cartEntryModel.setQuantity(quantity);
				cartEntryCollection.add(cartEntryModel);
			}
			existingcart.setCartEntry(cartEntryCollection);
			cartRepo.save(existingcart);
			return existingcart;
		}
	}

	@Override
	public CartModel removeFromCart(String productCode, UserModel user) {
		ProductModel productModel = productService.findProductModelByCode(productCode);
		CartModel existingcart =  cartRepo.findCartModelByUser(user);
		existingcart.getCartEntry().removeIf(cartEntryModel -> cartEntryModel.getProduct() == productModel);
		cartRepo.save(existingcart);
		return existingcart;
	}

	
	public CartModel createCart(ProductModel productModel, UserModel user, int quantity) {
		CartEntryModel cartEntryModel = new CartEntryModel();
		cartEntryModel.setProduct(productModel);
		cartEntryModel.setQuantity(quantity);
		Collection<CartEntryModel> cartEntryCollection = new ArrayList<>();
		cartEntryCollection.add(cartEntryModel);
	    cartModel.setCartEntry(cartEntryCollection);
		cartModel.setUser(user);
		return cartModel;
	}

	@Override
	public void clearCart(UserModel userModel){
		CartModel existingcart =  cartRepo.findCartModelByUser(userModel);
		cartRepo.delete(existingcart);
	}
}
