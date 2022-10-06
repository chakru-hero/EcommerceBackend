package com.portfolio.chakru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SuppressWarnings("unused")
@RequestMapping("/login")
public class LoginPageController {

	@GetMapping
	public String getLogin(Model model) {
	    return "login";
	}
}
