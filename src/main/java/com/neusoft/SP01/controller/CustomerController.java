package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.CustCheckInDTO;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.PageResponseBean;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("/*")
@RestController
@RequestMapping("/CustomerController")
public class CustomerController {
// 搜索所有自理老人(分页)
    @GetMapping("/showSelfCust")
    public PageResponseBean<CustCheckInDTO> showSelfCust(long cur,long pageSize){
        return null;
    }
// 搜索所有护理老人(分页)
    @GetMapping("/showCareCust")
    public PageResponseBean<CustCheckInDTO> showCareCust(long cur,long pageSize){
        return null;
    }

//  查询客户入住信息(分页)
    @GetMapping("/searchCust")
    public PageResponseBean<CustCheckInDTO> searchCust(String cname,String checkInTime,String type,long cur,long pageSize){
        return null;
    }
//  添加入住登记
    @PostMapping("/addCust")
    public ResponseBean<Integer> addCust(CustCheckInDTO data){
        return null;
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
