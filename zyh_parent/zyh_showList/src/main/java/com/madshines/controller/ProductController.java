package com.madshines.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.madshines.pojo.Product;
import com.madshines.service.ProductService;

@Controller
public class ProductController {
	@Resource(name="productServiceImpl")
	private ProductService productService;
	@RequestMapping("insertProduct")
	public ModelAndView insertProduct(Product product){
		ModelAndView modelAndView=new ModelAndView();
		productService.insertProduct(product);
		modelAndView.addObject("msg", "添加成功");
		modelAndView.setViewName("success");
		return modelAndView;
	}
	@RequestMapping("selectProduct")
	public ModelAndView selectProduct() {
		ModelAndView modelAndView=new ModelAndView();
		List<Product> selectProduct = productService.selectProduct();
		modelAndView.addObject("selectProduct", selectProduct);
		modelAndView.setViewName("showProduct");
		return modelAndView;
	}
}
