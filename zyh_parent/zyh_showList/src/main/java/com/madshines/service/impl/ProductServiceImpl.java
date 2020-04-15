package com.madshines.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.madshines.mapper.ProductMapper;
import com.madshines.pojo.Product;
import com.madshines.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Resource(name="productMapper")
	private ProductMapper productMapper;
	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		int insertProduct = productMapper.insertProduct(product);
		return insertProduct;
	}
	@Override
	public List<Product> selectProduct() {
		// TODO Auto-generated method stub
		return productMapper.selectProduct();
	}
	
}
