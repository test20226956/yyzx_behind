package com.neusoft.SP01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.SP01.po.Customer;
import com.neusoft.SP01.po.NursingProject;
import com.neusoft.SP01.po.NursingRecord;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.User;
import com.neusoft.SP01.service.UserService;

@CrossOrigin("*")
@RequestMapping("/UserController")
@RestController
public class UserController {
	@Autowired
    private UserService us;

	@GetMapping("/login")
    public ResponseBean<?> login(String account,String password) {
        return us.login(account, password);
    }

    @GetMapping("/showUser")
    public PageResponseBean<List<User>> getRegularUsers(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        
        return us.getRegularUsers(pageNum, pageSize);
    }

    @GetMapping("/searchUser")
    public PageResponseBean<User> searchUser(String userName){
        return null;
    }

    @GetMapping("/showUserCust")//这里应该新建一个DTO对应展示
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
