package com.neusoft.SP01.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.SP01.po.*;
import com.neusoft.SP01.service.CustomerService;
import com.neusoft.SP01.service.OutRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/GoOutController")
@RestController
public class OutRecordController {
    @Autowired
    OutRecordService ors;
    @Autowired
    private CustomerService cs;
    
 // 展示所有的外出退住申请列表（分页）
    @GetMapping("/showGoOut")
    public PageResponseBean<List<OutRecordWithName>> showGoOut(
            @RequestParam(defaultValue = "1") long pageNum,
            @RequestParam(defaultValue = "10") long pageSize) {
        return ors.showGoOut(pageNum, pageSize);
    }
    
  //多条件查询
    @GetMapping("/searchGoOut")
    public PageResponseBean<List<OutRecordWithName>> queryGoOut(
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) Integer state,
            @RequestParam(required = false) String applyTime,
            @RequestParam(defaultValue = "1") long pageNum,
            @RequestParam(defaultValue = "10") long pageSize) {
        
        return ors.queryGoOut(customerName, state, applyTime,pageNum, pageSize);
    }
  //审批外出退住
    @PostMapping("/checkGoOut")
    public ResponseBean<Integer> approveOut(
            @RequestParam Integer outRecordId,
            @RequestParam Integer state,
            @RequestParam Integer adminId) {
        return ors.approveOut(outRecordId, state, adminId);
    }

    //详情信息
    @GetMapping("/getRecord")
    public ResponseBean<OutDetailDTO> getOutDetail(
    		@RequestParam Integer outRecordId) {
        return ors.getOutDetail(outRecordId);
    }


    //客户管理模块显示老人信息（其实是增加了身份证号，入住时间以及到期时间这三项内容）
    @GetMapping("/showCust")
    public PageResponseBean<List<CustNursingManageDTO>> showCust(@RequestParam(defaultValue = "1")Integer pageNum,
                                                                 @RequestParam(defaultValue = "4")Integer pageSize, Integer userId){
        PageResponseBean<List<CustNursingManageDTO>> userCustManage = cs.findUserCustManage(pageNum, pageSize, userId);
        return userCustManage;
    }

    @PostMapping("/addGoOutRe")
    public ResponseBean<Integer> addGoOutRe(OutRecord outRecord){
        return null;
    }

    @GetMapping("/searchCust")//客户管理模块根据老人姓名模糊搜索
    public PageResponseBean<List<CustNursingManageDTO>> searchCust(@RequestParam(defaultValue = "1")Integer pageNum,
                                                                   @RequestParam(defaultValue = "4")Integer pageSize, Integer userId,String name){
        PageResponseBean<List<CustNursingManageDTO>> userCustManageByName = cs.findUserCustManageByName(pageNum, pageSize, userId, name);
        return userCustManageByName;
    }

    @GetMapping("/showCustGoOutRe")
    public PageResponseBean<List<CustOutRecordDTO>> showCustGoOutRe(@RequestParam(defaultValue = "1")Integer pageNum,
                                                                    @RequestParam(defaultValue = "4")Integer pageSize, Integer customerId){
        PageResponseBean<List<CustOutRecordDTO>> outRecordByCustomerId = ors.findOutRecordByCustomerId(pageNum, pageSize, customerId);
        return outRecordByCustomerId;
    }

    @PostMapping("/custGoOutCome")
    public ResponseBean<Integer> custGoOutCome(OutRecord outRecord){
        return null;
    }

    @GetMapping("/searchCustGoOutRe")
    public PageResponseBean<OutRecord> searchCustGoOutRe(String custName){
        return null;
    }
}
