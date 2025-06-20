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
public class GoOutController {
    @Autowired
    OutRecordService ors;
    @GetMapping("/showGoOut")
    public PageResponseBean<OutRecord> showGoOut(){
        return null;
    }

    @GetMapping("/searchGoOut")
    public PageResponseBean<OutRecord> searchGoOut(String custName){
        return null;
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
