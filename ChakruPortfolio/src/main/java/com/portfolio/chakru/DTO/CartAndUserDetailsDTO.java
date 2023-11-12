package com.portfolio.chakru.DTO;

import com.portfolio.chakru.models.CartModel;
import com.portfolio.chakru.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class CartAndUserDetailsDTO {
    CartModel cartModel;
    UserModel userModel;

    public CartModel getCartModel() {
        return cartModel;
    }

    public void setCartModel(CartModel cartModel) {
        this.cartModel = cartModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
