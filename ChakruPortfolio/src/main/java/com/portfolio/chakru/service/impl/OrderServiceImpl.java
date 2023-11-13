package com.portfolio.chakru.service.impl;

import com.portfolio.chakru.models.CartEntryModel;
import com.portfolio.chakru.models.CartModel;
import com.portfolio.chakru.models.OrderEntryModel;
import com.portfolio.chakru.models.OrderModel;
import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.repo.CartRepo;
import com.portfolio.chakru.repo.OrderRepo;
import com.portfolio.chakru.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private OrderRepo orderRepo;
    @Override
    public OrderModel createNewOrder(long cartId, UserModel userModel) {
        CartModel cartModel = cartRepo.findCartModelByUser(userModel);
        if(cartModel.getId()==cartId){
            return createNewOrderUsingCart(cartModel);
        }
        //else handle exception
        return null;
    }
    public OrderModel createNewOrderUsingCart(CartModel cartModel){
        OrderModel orderModel = convertCartToOrder(cartModel);
        orderRepo.save(orderModel);
        cartRepo.delete(cartModel);
        return orderModel;
    }

    public OrderModel convertCartToOrder(CartModel cartModel){
        OrderModel orderModel = new OrderModel();
        orderModel.setUser(cartModel.getUser());
        orderModel.setOrderTotal(cartModel.getCartTotal());
        Collection<OrderEntryModel> orderEntries = new ArrayList<>();
        for(CartEntryModel cartEntryModel: cartModel.getCartEntry()){
            orderEntries.add(convertCartEntryToOrderEntry(cartEntryModel));
        }
        orderModel.setOrderEntries(orderEntries);
        return orderModel;
    }

    public OrderEntryModel convertCartEntryToOrderEntry(CartEntryModel cartEntryModel){
        OrderEntryModel orderEntryModel = new OrderEntryModel();
        orderEntryModel.setQuantity(cartEntryModel.getQuantity());
        orderEntryModel.setProduct(cartEntryModel.getProduct());
        return orderEntryModel;
    }
}
