package com.portfolio.chakru.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.chakru.models.ProductModel;

public interface ProductRepo extends JpaRepository<ProductModel, String> {

}
