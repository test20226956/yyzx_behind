package com.neusoft.SP01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.User;
import com.neusoft.SP01.service.UserService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin("*")
@RequestMapping("/UserController")
@Controller
public class UserController {
	@Autowired
	private UserService us;
	
	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser() {
		System.out.println("控制器运行");
		return null;
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	@ResponseBody
	//session会话跟踪技术，依赖浏览器
	public ResponseBean<User> login(Integer userId,String password,HttpSession hs) {
		
		User data=new User();
		data.setUserId(userId);
		data.setPassword(password);
		
		return us.getUser(data);
	}
	@PostMapping("/loginRest/{userId}/{password}")
	public User loginRest(@PathVariable("userId") String userId,@PathVariable("password") String password) {
		
		System.out.println("userId="+userId);
		System.out.println("password="+password);
		
		return null;
	}

}
