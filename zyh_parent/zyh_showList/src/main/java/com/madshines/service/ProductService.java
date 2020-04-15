package com.madshines.service;

import java.util.List;

import com.madshines.pojo.Product;

public interface ProductService {
	int insertProduct(Product product);
	List<Product> selectProduct();
}
