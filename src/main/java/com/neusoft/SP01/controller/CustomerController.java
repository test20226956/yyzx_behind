package com.neusoft.SP01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.SP01.po.CustCheckInDTO;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.service.CheckInRecordService;
import com.neusoft.SP01.service.CustomerService;

@CrossOrigin("/*")
@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired  // 确保正确注入
    private CustomerService cs;
	@Autowired  // 确保正确注入
    private CheckInRecordService cirs;
	
// 搜索所有自理老人(分页)
    @GetMapping("/showSelfCust")
    public PageResponseBean<?> showSelfCust(long pageNum,long pageSize){
    	return cs.getSelfCareCustomersByPage(pageNum, pageSize);
    }
    
// 搜索所有护理老人(分页)
    @GetMapping("/showCareCust")
    public PageResponseBean<?>showCareCust(long pageNum,long pageSize){
        return cs.getCareCustomersByPage(pageNum,pageSize);
    }
 // 按条件搜索老人(分页)
    @GetMapping("/searchCust")
    public PageResponseBean<?> searchCustomers(
        @RequestParam(required = false) String type,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String checkInTime, // 改为String类型
        @RequestParam(defaultValue = "1") long pageNum,
        @RequestParam(defaultValue = "10") long pageSize) {
        
        return cs.searchCustomers(type, name, checkInTime, pageNum, pageSize);
    }
    @GetMapping("/searchCustByIdentity")
    public ResponseBean<?> searchCustByIdentity( String identity) {
        
        return cs.searchCustByIdentity(identity);
    }
//  添加入住登记
    @PostMapping("/addCust")
    public ResponseBean<String> addCheckIn(CustCheckInDTO data) {
        return cirs.addCustCheckIn(data);
    }
//  删除客户入住信息（逻辑删除，实为修改）
    @PostMapping("/deleteCust")
    public ResponseBean<Integer> deleteCust(Integer customerId){
        return null;
    }
//  编辑客户入住信息
    @PostMapping("/editCust")
//  因为修改的可能为客户信息也可能为客户入住信息，所以传的是CustCheckInDTO
    public ResponseBean<Integer> editCust(CustCheckInDTO data){
        return null;
    }
}
