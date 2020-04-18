package com.madshines.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.madshines.pojo.Product;

@Repository
public interface ProductMapper {
	int insertProduct(Product product);
	List<Product> selectProduct();
}
