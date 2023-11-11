package com.portfolio.chakru.controllers;

import com.portfolio.chakru.enums.Category;
import com.portfolio.chakru.models.ProductModel;
import com.portfolio.chakru.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StoreController {

    @Autowired
    private ProductService productService;
    @GetMapping("/ping")
    public String sayHello(){
        return "pong";
    }

    @GetMapping("/products")
    @ResponseBody
    public List<ProductModel> getProducts(@RequestParam String sort, @RequestParam int limit , @RequestParam(required = false) String category) {
        if (category.equals("undefined")){
            return productService.findAllProducts(sort, limit);
    }
        else
            return productService.findAllProducts(sort, limit, category);

    }

    @GetMapping("/getAllCategories")
    public String[] getAllCategories(){
        return Arrays.stream(Category.values()).map(Enum::name).toArray(String[]::new);
    }




}
