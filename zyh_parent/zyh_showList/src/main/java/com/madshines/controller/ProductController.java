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
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

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
	public ModelAndView queryProduct(String name){
		Product product=null;
		ModelAndView modelAndView=new ModelAndView();
		SolrDocumentList queryProduct = productService.queryProduct(name);
		for (SolrDocument solrDocument : queryProduct) {
			product=new Product();
			int id = Integer.parseInt((String)solrDocument.get("id"));
			product.setId(id);
			String name1 = solrDocument.get("name").toString();
			product.setName(name1);
			String origin = solrDocument.get("origin").toString();
			product.setOrigin(origin);
			modelAndView.addObject("pro", product);
		}
		modelAndView.setView(new MappingJackson2JsonView());;
		return modelAndView;
	}
}
