package com.portfolio.chakru.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.chakru.exceptions.ProductNotFoundException;
import com.portfolio.chakru.models.ProductModel;
import com.portfolio.chakru.repo.ProductRepo;
import com.portfolio.chakru.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public void deleteProductModelByCode(String code) {
      productRepo.deleteById(code);		
	}

	@Override
	public ProductModel updateProuct(ProductModel productModel) {
		return productRepo.save(productModel);
	}

	@Override
	public ProductModel addProduct(ProductModel productModel) {
		return productRepo.save(productModel);
	}

	@Override
	public List<ProductModel> findAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public ProductModel findProductModelByCode(String code)	{
		return productRepo.findById(code)
				.orElseThrow(() -> new ProductNotFoundException("Product with ID " + code + " not found."));		
	}

	
	
	}
	
