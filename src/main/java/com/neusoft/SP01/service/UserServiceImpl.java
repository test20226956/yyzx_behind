package com.neusoft.SP01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.UserDao;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao ud;
	@Override
	public ResponseBean<User> getUser(User user) {
		System.out.println("服务层运行");
		User result=ud.getUser(user.getUserId());
		ResponseBean<User> rb;
		if(result==null) {
			rb=new ResponseBean<>(500,"账号错误");
		}else if(!user.getPassword().equals(result.getPassword())){
			rb=new ResponseBean<>(500,"密码错误");
		}else {
			result.setPassword(null);
			rb=new ResponseBean<>(200,"登录成功",result);
		}
		return rb;
	}
}
