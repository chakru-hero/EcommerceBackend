package com.portfolio.chakru.service.impl;

import com.portfolio.chakru.exceptions.ProductNotFoundException;
import com.portfolio.chakru.models.ProductModel;
import com.portfolio.chakru.repo.ProductRepo;
import com.portfolio.chakru.repo.impl.ProductRepoImpl;
import com.portfolio.chakru.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ProductRepoImpl productRepoImpl;
	
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
	public List<ProductModel> findAllProducts(String sort, int limit , String category) {
		if(sort.equals("asc")) {
			return productRepo.findAllProductsOrderByNameAsc(category, limit);
			//return productRepo.findAllProducts(sort,limit,category);
		}
		else return productRepo.findAllProductsOrderByNameDesc(category, limit);
	}

	@Override
	public List<ProductModel> findAllProducts(String sort, int limit) {
		return productRepo.findAllProducts(limit);
	}

	@Override
	public List<ProductModel> findAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public ProductModel findProductModelByCode(String code)	{
		return productRepo.findById(code)
				.orElseThrow(() -> new ProductNotFoundException("Product with ID " + code + " not found......"));		
	}

	
	
	}
	
