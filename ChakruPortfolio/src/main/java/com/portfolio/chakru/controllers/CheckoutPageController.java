package com.portfolio.chakru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.chakru.models.CartModel;
import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.repo.CartRepo;
import com.portfolio.chakru.service.UserService;

@Controller
@RequestMapping("/checkout")
@SuppressWarnings("unused")
public class CheckoutPageController {

	@Autowired
	private CartRepo cartrepo;
	
	@Autowired
	private UserService userService;

	@GetMapping("/{userid}")
	public String getCartAndUserDetails(@PathVariable("userid") Long userid, Model model) {

		UserModel userModel = userService.findUserModelById(userid);
		CartModel cartModel = cartrepo.findCartModelByUser(userModel);
		model.addAttribute("cart" ,cartModel);
		model.addAttribute("user" ,userModel);
		return "CheckoutPage";
	}
}
