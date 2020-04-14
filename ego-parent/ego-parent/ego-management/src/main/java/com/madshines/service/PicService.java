package com.madshines.service;

import java.util.List;

import com.madshines.pojo.Pic;

public interface PicService {
	int insertPic(Pic pic);
	List<Pic> selectPics();
	//int deleteById(int id);
}
