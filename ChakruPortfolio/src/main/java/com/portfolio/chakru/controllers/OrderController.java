package com.portfolio.chakru.controllers;

import com.portfolio.chakru.config.securityConfig.UserAuthProvider;
import com.portfolio.chakru.models.OrderModel;
import com.portfolio.chakru.repo.UserRepo;
import com.portfolio.chakru.service.OrderService;
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
@RequestMapping("/order")
@Log4j2
public class OrderController {
    @Autowired
    private UserAuthProvider userAuthProvider;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderModel> createOrder(@RequestParam long cartId,  @RequestHeader(HttpHeaders.AUTHORIZATION) String token){
        String[] authElements = token.split(" ");
        String username = userAuthProvider.getDecodedJWT(authElements[1]).getIssuer();
        OrderModel orderModel = orderService.createNewOrder(cartId,userRepo.findUserModelByUsername(username));
        return new ResponseEntity<>(orderModel, HttpStatus.OK);
    }
}
