package com.madshines.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.madshines.pojo.Pic;
import com.madshines.service.PicService;

@Controller
public class PicController {
	@Resource(name = "picServiceImpl")
	private PicService picService;
	@RequestMapping("insertPic")
	public ModelAndView insertPic(HttpServletRequest request) throws IllegalStateException, IOException {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		MultipartHttpServletRequest multipartFile=(MultipartHttpServletRequest)request;
		MultipartFile file = multipartFile.getFile("file");
		String originalFilename = file.getOriginalFilename();
		File desk=new File(originalFilename);
		file.transferTo(desk);
		Pic pic=new Pic();
		pic.setPath(originalFilename);
		picService.insertPic(pic);
		modelAndView.addObject("msg", "上传成功");
		return modelAndView;
	}
	@RequestMapping("selectPics")
	public ModelAndView selectPics() {
		ModelAndView modelAndView=new ModelAndView();
		List<Pic> selectPics = picService.selectPics();
		modelAndView.addObject("pics", selectPics);
		modelAndView.setViewName("showPics");
		return modelAndView;
	}
//	@RequestMapping("deleteById")
//	public ModelAndView deleteById(int id) {
//		ModelAndView modelAndView=new ModelAndView();
//		int deleteById = picService.deleteById(id);
//		modelAndView.addObject("msg", "删除成功");
//		return modelAndView;
//	}
}
