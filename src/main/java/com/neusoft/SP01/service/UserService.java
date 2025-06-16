package com.neusoft.SP01.service;

import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.User;

public interface UserService {

	public ResponseBean<User> getUser(User user) ;

}
