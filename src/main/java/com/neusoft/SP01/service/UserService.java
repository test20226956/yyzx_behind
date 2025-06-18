package com.neusoft.SP01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.UserDao;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.User;

@Service
public class UserService {
    
    @Autowired
    private UserDao userDao;
    
    /*用户登录验证*/
    public ResponseBean<User> login(String account, String password) {
        // 1. 验证账号是否存在
        User user = userDao.findUserByAccount(account);
        if (user == null) {
            return new ResponseBean<>(500, "账号不存在");
        }
        
        // 2. 验证密码是否正确
        if (!user.getPassword().equals(password)) {
            return new ResponseBean<>(500, "密码错误");
        }
        
        // 3. 登录成功，返回用户信息(密码置空)
        user.setPassword(null);
        return new ResponseBean<>(200, "登录成功", user);
    }
}