package com.portfolio.chakru.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.chakru.models.ProductModel;
import com.portfolio.chakru.service.ProductService;


@Controller
@RequestMapping("/p")
public class ProductPageController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String getAllProducts(Model model){
		List<ProductModel> productModel = productService.findAllProducts();
		model.addAttribute("productModel" , productModel);
	    return "productListPage";
		
	}

	@GetMapping("/{code}")
	public String getProductById(@PathVariable("code") String code , Model model) {
		
		ProductModel productModel = productService.findProductModelByCode(code);
		model.addAttribute("productModel",productModel);
	    return "productPage";
	}
	
}
