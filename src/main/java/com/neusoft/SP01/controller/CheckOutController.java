package com.neusoft.SP01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.SP01.po.CheckOutRecord;
import com.neusoft.SP01.po.CheckOutRecordWithName;
import com.neusoft.SP01.po.Customer;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.service.CheckOutRecordService;
import com.neusoft.SP01.service.CustomerService;

@CrossOrigin("*")
@RequestMapping("/CheckOutController")
@RestController
public class CheckOutController {
	@Autowired  // 确保正确注入
    private CustomerService cs;
	@Autowired  // 确保正确注入
    private CheckOutRecordService cors;
	
	// 展示所有的退住申请列表（分页）
    @GetMapping("/showCheckOut")
    public PageResponseBean<List<CheckOutRecordWithName>> showCheckOut(
            @RequestParam(defaultValue = "1") long pageNum,
            @RequestParam(defaultValue = "10") long pageSize) {
        return cors.showCheckOut(pageNum, pageSize);
    }
    //多条件查询
    @GetMapping("/searchCheckOut")
    public PageResponseBean<List<CheckOutRecordWithName>> queryCheckOut(
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) Integer state,
            @RequestParam(required = false) String applyTime,
            @RequestParam(defaultValue = "1") long pageNum,
            @RequestParam(defaultValue = "10") long pageSize) {
        
        return cors.queryCheckOut(customerName, state, applyTime,pageNum, pageSize);
    }
    //审批退住
    @PostMapping("/sheckCheckOut")
    public ResponseBean<Integer> approveCheckOut(
            @RequestParam Integer checkOutRecordId,
            @RequestParam Integer state,
            @RequestParam Integer adminId) {
        return cors.approveCheckOut(checkOutRecordId, state, adminId);
    }
    
    
    @PostMapping("/checkCheckOut")
    public ResponseBean<Integer> checkCheckOut(String checkOutId, Integer state){
        return null;
    }

    @GetMapping("/showCust")
    public PageResponseBean<Customer> showCust(String custId){
        return null;
    }

    @GetMapping("/searchCust")
    public PageResponseBean<Customer> searchCust(String userId, String cuatName){
        return null;
    }

    @PostMapping("/addCheckOutRe")
    public ResponseBean<Integer> addCheckOutRe(CheckOutRecord checkOutRecord){
        return null;
    }

    @GetMapping("/showCustCheckOutRe")
    public PageResponseBean<CheckOutRecord> showCustCheckOutRe(String userId){
        return null;
    }

    @GetMapping("/searchCustCheckOutRe")
    public PageResponseBean<CheckOutRecord> searchCustCheckOutRe(String cuatName){
        return null;
    }
}
