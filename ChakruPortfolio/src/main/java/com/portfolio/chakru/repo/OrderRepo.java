package com.portfolio.chakru.repo;

import com.portfolio.chakru.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderModel,Long> {

}
