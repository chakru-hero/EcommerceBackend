package com.portfolio.chakru.repo;

import com.portfolio.chakru.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<ProductModel, String> {
    @Query(value = "SELECT p.* FROM product_model p WHERE p.category = :category LIMIT :limit", nativeQuery = true)
     List<ProductModel> findAllProductsOrderByNameAsc(@Param("category") String category,
                                        @Param("limit") int limit);
    @Query(value = "SELECT p.* FROM product_model p WHERE p.category = :category LIMIT :limit", nativeQuery = true)
    List<ProductModel> findAllProductsOrderByNameDesc(@Param("category") String category,
                                                     @Param("limit") int limit);
    @Query(value = "SELECT p.* FROM product_model p LIMIT :limit", nativeQuery = true)
    List<ProductModel> findAllProducts(@Param("limit") int limit);

}
