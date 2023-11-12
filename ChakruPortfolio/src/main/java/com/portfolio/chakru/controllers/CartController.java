package com.portfolio.chakru.controllers;

import com.portfolio.chakru.config.securityConfig.UserAuthProvider;
import com.portfolio.chakru.models.CartModel;
import com.portfolio.chakru.models.ProductModel;
import com.portfolio.chakru.repo.UserRepo;
import com.portfolio.chakru.service.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@Log4j2
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private UserAuthProvider userAuthProvider;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add")
    public ResponseEntity<CartModel> addToCart(@RequestParam ProductModel productModel, int quantity , @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        String username = userAuthProvider.getDecodedJWT(token).getIssuer();
        CartModel cartmodel = cartService.addToCart(productModel,userRepo.findUserModelByUsername(username), quantity);
        return new ResponseEntity<>(cartmodel,HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<CartModel> removeFromCart(@RequestParam ProductModel productModel, @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        String username = userAuthProvider.getDecodedJWT(token).getIssuer();
        CartModel cartmodel = cartService.removeFromCart(productModel,userRepo.findUserModelByUsername(username));
        return new ResponseEntity<>(cartmodel,HttpStatus.OK);
    }

    @PostMapping("/clear")
    public ResponseEntity clearCart(@RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        String username = userAuthProvider.getDecodedJWT(token).getIssuer();
        cartService.clearCart(userRepo.findUserModelByUsername(username));
        return new ResponseEntity(HttpStatus.OK);
    }
}
