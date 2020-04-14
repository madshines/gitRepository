package com.madshines.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.madshines.pojo.Pic;

@Repository
public interface AllPic {
	@Select("Select * from pic")
	List<Pic> selectAll();
}
