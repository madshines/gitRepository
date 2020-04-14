package com.madshines.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.madshines.pojo.Pic;
@Repository
public interface PicMapper {
	int insertPic(Pic pic);
	List<Pic> selectPics();
	//int deleteById(int id);
}
