package com.portfolio.chakru.service;

import java.util.List;

import com.portfolio.chakru.models.ProductModel;

public interface ProductService {

	void deleteProductModelByCode(String code);

	ProductModel updateProuct(ProductModel productModel);

	ProductModel addProduct(ProductModel productModel);

	List<ProductModel> findAllProducts();

	ProductModel findProductModelByCode(String code);
}
