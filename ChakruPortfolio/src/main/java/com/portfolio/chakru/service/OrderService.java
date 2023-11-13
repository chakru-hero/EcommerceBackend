package com.portfolio.chakru.service;

import com.portfolio.chakru.models.OrderModel;
import com.portfolio.chakru.models.UserModel;

public interface OrderService {
    public OrderModel createNewOrder(long cartId, UserModel userModel);
}
