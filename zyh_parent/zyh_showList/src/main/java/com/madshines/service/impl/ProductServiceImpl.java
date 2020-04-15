package com.madshines.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madshines.mapper.ProductMapper;
import com.madshines.pojo.Product;
import com.madshines.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Resource(name="productMapper")
	private ProductMapper productMapper;
	@Autowired
	private SolrServer solrServer;
	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		int insertProduct = productMapper.insertProduct(product);
		return insertProduct;
	}
	@Override
	public List<Product> selectProduct() throws SolrServerException, IOException {
		// TODO Auto-generated method stub
		List<Product> selectProduct = productMapper.selectProduct();
//		for (Product product : selectProduct) {
//			SolrInputDocument document=new SolrInputDocument();
//			document.setField("id", product.getId());
//			document.setField("name", product.getName());
//			document.setField("origin", product.getOrigin());
//			solrServer.add(document);
//		}
//		solrServer.commit();	
//		SolrQuery solrQuery=new SolrQuery();
//		solrQuery.add("p", "name:白色");
//		QueryResponse query = solrServer.query(solrQuery);
//		SolrDocumentList results = query.getResults();
//		for (SolrDocument solrDocument : results) {
//			
//		}
		return selectProduct;
	}
}
