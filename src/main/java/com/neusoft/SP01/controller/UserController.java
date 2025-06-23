package com.neusoft.SP01.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.SP01.po.CustDailyNursingDTO;
import com.neusoft.SP01.po.CustNursingRecordDTO;
import com.neusoft.SP01.po.Customer;
import com.neusoft.SP01.po.NursingRecord;
import com.neusoft.SP01.po.NursingServiceDailyDTO;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.User;
import com.neusoft.SP01.service.CustomerService;
import com.neusoft.SP01.service.NursingRecordService;
import com.neusoft.SP01.service.NursingServiceService;
import com.neusoft.SP01.service.UserService;

@CrossOrigin("*")
@RequestMapping("/UserController")
@RestController
public class UserController {
	@Autowired
    private UserService us;
    @Autowired
    private CustomerService cs;
    @Autowired
    private NursingServiceService nss;
    @Autowired
    private NursingRecordService nrs;
    //登录
	@GetMapping("/login")
    public ResponseBean<?> login(String account,String password) {
        return us.login(account, password);
    }
	//展示
    @GetMapping("/showUser")
    public PageResponseBean<List<User>> getRegularUsers(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        
        return us.getRegularUsers(pageNum, pageSize);
    }
    //搜索
    @GetMapping("/searchUser")
    public PageResponseBean<List<User>> searchRegularUsers(
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String account,
            @RequestParam(required = false) String employmentDate,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        
        return us.searchRegularUsers(
                userName, account, employmentDate, pageNum, pageSize);
    }
    
    //新增员工
    @PostMapping("/addUser")
    public ResponseBean<String> addUser(@RequestBody User user) {
        return us.addUser(user);
    }
    
    //更新
    @PostMapping("/editUser")
    public ResponseBean<String> updateUser(@RequestBody User user) {
        return us.updateUser(user);
    }
    
  //删除
    @PostMapping("/delectUser")
    public ResponseBean<String> deleteUser(@RequestParam Integer userId) {
        return us.deleteUser(userId);
    }

    @GetMapping("/showUserCust")//这里应该新建一个DTO对应展示
    public PageResponseBean<List<CustDailyNursingDTO>> showUserCust(@RequestParam(defaultValue = "1")Integer pageNum,
                                                                    @RequestParam(defaultValue = "4")Integer pageSize,Integer userId){
        PageResponseBean<List<CustDailyNursingDTO>> userCust = cs.findUserCust(pageNum, pageSize, userId);
        return userCust;

    }

    @GetMapping("/showUnCust")
    public PageResponseBean<Customer> showUnCust(String userId){
        return null;
    }

    @GetMapping("/searchUnCust")
    public PageResponseBean<Customer> searchUnCust(String custName){
        return null;
    }

    @GetMapping("/searchUserCust")//根据老人姓名模糊搜索
    public PageResponseBean<List<CustDailyNursingDTO>> searchUserCust(@RequestParam(defaultValue = "1")Integer pageNum,
                                                                      @RequestParam(defaultValue = "4")Integer pageSize,Integer userId,String name){
        PageResponseBean<List<CustDailyNursingDTO>> userCustByName = cs.findUserCustByName(pageNum, pageSize, userId, name);
        return userCustByName;
    }

    @PostMapping("/addUserCust")
    public ResponseBean<Integer> addUserCust(String userId, String custId){
        return null;
    }

    @PostMapping("/deleteUserCust")
    public ResponseBean<Integer> deleteUserCust(String userId, String custId){
        return null;
    }


    @GetMapping("/showCustPro")/*======对应原型护工 日常护理 显示用户的护理服务=====*/
    public PageResponseBean<List<NursingServiceDailyDTO>> showCustPro(@RequestParam(defaultValue = "1")Integer pageNum,
                                                                      @RequestParam(defaultValue = "4")Integer pageSize,Integer customerId){
        PageResponseBean<List<NursingServiceDailyDTO>> n = nss.findNursingServiceByCustomerId(pageNum, pageSize, customerId);
        return n;
    }

    @GetMapping("/searchCustPro")//对应原型护工 日常护理  按项目名字搜索用户的持有的护理服务
    public PageResponseBean<List<NursingServiceDailyDTO>> searchCustPro(@RequestParam(defaultValue = "1")Integer pageNum,
                                                          @RequestParam(defaultValue = "4")Integer pageSize,Integer customerId,String name){
        PageResponseBean<List<NursingServiceDailyDTO>> nursingServiceByName = nss.findNursingServiceByName(pageNum, pageSize, customerId, name);
        return nursingServiceByName;
    }

    @PostMapping("/addCareRecord")
    public ResponseBean<Integer> addCareRecord(String custProRe, NursingRecord nursingRecord){
        return null;
    }

    @GetMapping("/showCareRecord")//展示老人所有的护理记录（护工 健康管家 护理记录）
    public PageResponseBean<List<CustNursingRecordDTO>> shoeCareRecord(@RequestParam(defaultValue = "1")Integer pageNum,
                                                          @RequestParam(defaultValue = "4")Integer pageSize,Integer customerId){
        PageResponseBean<List<CustNursingRecordDTO>> cnrd = nrs.findByCustomerId(pageNum, pageSize, customerId);
        return cnrd;
    }
}
