package com.portfolio.chakru.service;

import com.portfolio.chakru.models.ProductModel;

import java.util.List;

public interface ProductService {

	void deleteProductModelByCode(String code);

	ProductModel updateProuct(ProductModel productModel);

	ProductModel addProduct(ProductModel productModel);

	List<ProductModel> findAllProducts(String sort, int limit, String category);

	List<ProductModel> findAllProducts(String sort, int limit);

	List<ProductModel> findAllProducts();

	ProductModel findProductModelByCode(String code);
}
