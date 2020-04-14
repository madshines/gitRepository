package com.madshines.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.madshines.service.PicService;

@Controller
public class PicController {
	@Resource(name = "picServiceImpl")
	private PicService picService;
	@RequestMapping("showPics")
	public ModelAndView shoePics() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("list", picService.selectAll());
		modelAndView.setViewName("showPics");
		return modelAndView;
	}
}
