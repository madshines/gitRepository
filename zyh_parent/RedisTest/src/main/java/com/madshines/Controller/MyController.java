package com.madshines.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.madshines.redisUtils.RedisService;

@Controller
public class MyController {
	@Autowired
	private RedisService redisService;
	String str=null;
	@RequestMapping("setString")
	public ModelAndView setString(@RequestParam("str") String str1){
		ModelAndView modelAndView=new ModelAndView();
		boolean sSet = redisService.set("str1", str1);
		if (sSet) {
			modelAndView.addObject("msg", "添加成功");
			str=str1;
		}else {
			modelAndView.addObject("msg", "添加失败");
		}
		modelAndView.setView(new MappingJackson2JsonView());
		return modelAndView;
	}
	@RequestMapping("getString")
	public ModelAndView getString(String key){
		ModelAndView modelAndView=new ModelAndView();
		Object str = redisService.get(key);
		modelAndView.addObject("str", str);		
		modelAndView.setView(new MappingJackson2JsonView());
		return modelAndView;
	}
}
