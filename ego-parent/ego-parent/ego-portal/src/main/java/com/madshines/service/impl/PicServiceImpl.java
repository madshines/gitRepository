package com.madshines.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madshines.mapper.AllPic;
import com.madshines.pojo.Pic;
import com.madshines.service.PicService;

@Service
public class PicServiceImpl implements PicService{
	
	@Autowired
	private AllPic allPic;
	@Override
	public List<Pic> selectAll() {
		// TODO Auto-generated method stub
		return allPic.selectAll();
	}
}
