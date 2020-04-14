package com.madshines.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madshines.mapper.PicMapper;
import com.madshines.pojo.Pic;
import com.madshines.service.PicService;
@Service
public class PicServiceImpl implements PicService{
	
	@Autowired
	private PicMapper picMapper;
	@Override
	public int insertPic(Pic pic) {
		// TODO Auto-generated method stub
		int insertPic = picMapper.insertPic(pic);
		return insertPic;
	}
	@Override
	public List<Pic> selectPics() {
		// TODO Auto-generated method stub
		List<Pic> selectPics = picMapper.selectPics();
		return selectPics;
	}
//	@Override
//	public int deleteById(int id) {
//		// TODO Auto-generated method stub
//		int deleteById = picMapper.deleteById(id);
//		return deleteById;
//	}
}
