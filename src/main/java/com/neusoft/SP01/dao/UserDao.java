package com.neusoft.SP01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neusoft.SP01.po.User;
@Mapper
public interface UserDao {
	@Select("select * from user where userId=#{userId}")
	public User getUser(Integer userId);

}
