package com.portfolio.chakru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.chakru.models.CartModel;
import com.portfolio.chakru.repo.CartRepo;
import com.portfolio.chakru.service.UserService;

@Controller
@RequestMapping("/cart")
public class CartPageController {

//	@Autowired
//	private CartService cartService;

	@Autowired
	private CartRepo cartrepo;
	
	@Autowired
	private UserService userService;

	@GetMapping("/{userid}")
	public String getCart(@PathVariable("userid") Long userid, Model model) {

		CartModel cartModel = cartrepo.findCartModelByUser(userService.findUserModelById(userid));
		model.addAttribute("cart" ,cartModel);
		return "Cartpage";
	}
}
