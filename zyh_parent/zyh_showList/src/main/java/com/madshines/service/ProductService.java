package com.madshines.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocumentList;

import com.madshines.pojo.Product;

public interface ProductService {
	int insertProduct(Product product);
	List<Product> selectProduct() throws SolrServerException, IOException;
	SolrDocumentList queryProduct(String name);
}
