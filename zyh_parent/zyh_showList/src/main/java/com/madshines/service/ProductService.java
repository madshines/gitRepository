package com.madshines.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.madshines.pojo.Product;

public interface ProductService {
	int insertProduct(Product product);
	List<Product> selectProduct() throws SolrServerException, IOException;
}
