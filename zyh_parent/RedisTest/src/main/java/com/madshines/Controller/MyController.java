package com.madshines.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
	//String str=null;
	@Autowired
    private RedisTemplate<String, Object> redisTemplate1;
	@RequestMapping("setString")
	public ModelAndView setString(@RequestParam("str") String str1){
		ModelAndView modelAndView=new ModelAndView();
		boolean sSet = redisService.set("str1", str1);
		if (sSet) {
			modelAndView.addObject("msg", "添加成功");
			//str=str1;
		}else {
			modelAndView.addObject("msg", "添加失败");
		}
		modelAndView.setView(new MappingJackson2JsonView());
		return modelAndView;
	}
	@RequestMapping("getString")
	public ModelAndView getString(@RequestParam("key")String key){
		System.out.println(key);
		ModelAndView modelAndView=new ModelAndView();
		String str = (String)redisService.get(key);
		System.out.println(str);
		modelAndView.addObject("str", str);		
		modelAndView.setView(new MappingJackson2JsonView());
		return modelAndView;
	}
	@RequestMapping("getListSize")
	public ModelAndView getList(@RequestParam("key") String key){
		long lGetListSize = redisService.lGetListSize(key);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("ListSize", lGetListSize);
		modelAndView.setView(new MappingJackson2JsonView());
		return modelAndView;
	}
	@RequestMapping("getListContext")
	public ModelAndView getListContext(@RequestParam("key") String key,@RequestParam("begin") String begin,@RequestParam("end") String end ){
		System.out.println(begin.getClass()+" "+end.getClass());
		long beginLong = Long.parseLong(begin);
		long EndLong = Long.parseLong(end);
		System.out.println(beginLong+" "+EndLong+" "+key);
		ModelAndView modelAndView=new ModelAndView();
		List<Object> lGet = redisService.lGet(key, beginLong, EndLong);
		for (Object object : lGet) {
			long i=Long.parseLong(object.toString());
			System.out.println(Long.parseLong(object.toString()));
			//modelAndView.addObject("ListSize", i);
		}
		modelAndView.addObject("ListSize", lGet);
//		List<Object> range = redisTemplate1.opsForList().range("link2", 0, -1);
//		System.out.println("list长度"+range.size());
//		for (Object object : range) {
//			System.out.println(Long.parseLong(object.toString()));
//		}
		modelAndView.setView(new MappingJackson2JsonView());
		return modelAndView;
	}
	@RequestMapping("getListContextIndex")
	public ModelAndView getListContextIndex(@RequestParam("key") String key,@RequestParam("index") String index){
		long parseLong = Long.parseLong(index);
		System.out.println(parseLong);
		long lGetIndex = (long)redisService.lGetIndex(key, parseLong);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("List",lGetIndex);
		modelAndView.setView(new MappingJackson2JsonView());
		return modelAndView;
	}
}
