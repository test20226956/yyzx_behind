package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.*;
import org.springframework.web.bind.annotation.*;

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
    public PageResponseBean<Customer> showUserCust(String userId){
        return null;
    }

    @GetMapping("/showUnCust")
    public PageResponseBean<Customer> showUnCust(String userId){
        return null;
    }

    @GetMapping("/searchUnCust")
    public PageResponseBean<Customer> searchUnCust(String custName){
        return null;
    }

    @GetMapping("/searchUserCust")
    public PageResponseBean<Customer> searchUserCust(String custName){
        return null;
    }

    @PostMapping("/addUserCust")
    public ResponseBean<Integer> addUserCust(String userId, String custId){
        return null;
    }

    @PostMapping("/deleteUserCust")
    public ResponseBean<Integer> deleteUserCust(String userId, String custId){
        return null;
    }

    @PostMapping("/addUser")
    public ResponseBean<Integer> addUser(User user){
        return null;
    }

    @PostMapping("/editUser")
    public ResponseBean<Integer> editUser(User user){
        return null;
    }

    @GetMapping("/showCustPro")
    public PageResponseBean<NursingProject> showCustPro(String cutsId){
        return null;
    }

    @GetMapping("/searchCustPro")
    public PageResponseBean<NursingProject> searchCustPro(String custId, String proName){
        return null;
    }

    @PostMapping("/addCareRecord")
    public ResponseBean<Integer> addCareRecord(String custProRe, NursingRecord nursingRecord){
        return null;
    }

    @GetMapping("/showCareRecord")
    public PageResponseBean<NursingRecord> shoeCareRecord(String cuatId){
        return null;
    }
}
