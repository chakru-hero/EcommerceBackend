package com.portfolio.chakru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.chakru.models.CartModel;
import com.portfolio.chakru.models.UserModel;

public interface CartRepo extends JpaRepository<CartModel,Long> {

	CartModel findCartModelByUser(UserModel user);
}
