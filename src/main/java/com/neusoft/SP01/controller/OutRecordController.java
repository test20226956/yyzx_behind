package com.neusoft.SP01.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.SP01.po.*;
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
    
 // 展示所有的退住申请列表（分页）
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

    

    @PostMapping("/checkGoOut")
    public ResponseBean<Integer> goCheckOut(String goOutId, Integer state){
        return null;
    }

    @GetMapping("/showCust")
    public PageResponseBean<Customer> showCust(String custId){
        return null;
    }

    @PostMapping("/addGoOutRe")
    public ResponseBean<Integer> addGoOutRe(OutRecord outRecord){
        return null;
    }

    @GetMapping("/searchCust")
    public PageResponseBean<Customer> searchCust(String userId, String cuatName){
        return null;
    }

    @GetMapping("/showCustGoOutRe")
    public PageResponseBean<List<CustOutRecordDTO>> showCustGoOutRe(Integer pageNum, Integer pageSize, Integer customerId){
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
