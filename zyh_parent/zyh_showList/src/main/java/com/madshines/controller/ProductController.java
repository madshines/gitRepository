package com.madshines.controller;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.madshines.pojo.Product;
import com.madshines.service.ProductService;

@Controller
public class ProductController {
	@Resource(name="productServiceImpl")
	private ProductService productService;
	@Autowired
	private SolrServer solrServer;
	@RequestMapping("insertProduct")
	public ModelAndView insertProduct(Product product){
		ModelAndView modelAndView=new ModelAndView();
		productService.insertProduct(product);
		modelAndView.addObject("msg", "添加成功");
		modelAndView.setViewName("success");
		return modelAndView;
	}
	@RequestMapping("selectProduct")
	public ModelAndView selectProduct() throws SolrServerException, IOException {
		ModelAndView modelAndView=new ModelAndView();
		List<Product> selectProduct = productService.selectProduct();
		for (Product product : selectProduct) {
			SolrInputDocument document=new SolrInputDocument();
			document.setField("id", product.getId());
			document.setField("name", product.getName());
			document.setField("origin", product.getOrigin());
			solrServer.add(document);
		}
		solrServer.commit();
		modelAndView.addObject("selectProduct", selectProduct);
		modelAndView.setViewName("showProduct");
		return modelAndView;
	}
	@RequestMapping("queryProduct")
	public ModelAndView queryProduct(String name) throws SolrServerException{
		System.out.println(name);
		ModelAndView modelAndView=new ModelAndView();
		SolrQuery solrQuery=new SolrQuery();
		solrQuery.add("p", "name:白色");
		QueryResponse query = solrServer.query(solrQuery);
		SolrDocumentList results = query.getResults();
		for (SolrDocument solrDocument : results) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("name"));
			System.out.println(solrDocument.get("origin"));
			
			//modelAndView.addObject("queryProduct", solrDocument);
		}
		//modelAndView.setViewName("queryProduct");
		return modelAndView;
	}
}
