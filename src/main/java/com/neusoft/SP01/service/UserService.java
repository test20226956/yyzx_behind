package com.neusoft.SP01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.UserDao;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.User;

@Service
public class UserService {
    
    @Autowired
    private UserDao ud;
    
    /*用户登录验证*/
    public ResponseBean<User> login(String account, String password) {
        // 1. 验证账号是否存在
        User user = ud.findUserByAccount(account);
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
    
    public PageResponseBean<List<User>> getRegularUsers(int pageNum, int pageSize) {
        try {
            // 参数校验
            if (pageNum < 1) pageNum = 1;
            if (pageSize < 1 || pageSize > 100) pageSize = 10;
            
            // 计算偏移量
            int offset = (pageNum - 1) * pageSize;
            
            // 查询数据
            List<User> users = ud.findUsersByTypeWithPage(offset, pageSize);
            
            // 检查查询结果是否为空
            if (users == null || users.isEmpty()) {
                return new PageResponseBean<>(500, "无数据", null);
            }
            
            // 查询总数
            long total = ud.countUsersByType();
            
            // 构建响应
            PageResponseBean<List<User>> response = new PageResponseBean<>(200, "查询成功", users);
            response.setTotal(total);
            return response;
            
        } catch (Exception e) {
            return new PageResponseBean<>(500, "系统错误：" + e.getMessage(), null);
        }
    }
}