package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.Customer;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RequestMapping("/UserController")
@RestController
public class UserController {

    @GetMapping("/login")
    public ResponseBean<User> login(String id, String pwd){
        return null;
    }

    @GetMapping("/showUser")
    public PageResponseBean<User> showUser(){
        return null;
    }

    @GetMapping("/searchUser")
    public PageResponseBean<User> searchUser(String userName){
        return null;
    }

    @GetMapping("/showUserCust")
    public PageResponseBean<Customer> searchUserCust(String userId){
        return null;
    }

    @GetMapping("/showUnUser")
    public PageResponseBean<Customer> searchUnCust(String userId){
        return null;
    }

}
