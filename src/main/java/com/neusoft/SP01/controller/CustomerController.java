package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.CustCheckInDTO;
import com.neusoft.SP01.po.ResponseBean;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("/*")
@RestController
@RequestMapping("/CustomerController")
public class CustomerController {
// 搜索所有自理老人
    @GetMapping("/showSelfCust")
    public ResponseBean<CustCheckInDTO> showSelfCust(){
        return null;
    }
// 搜索所有护理老人
    @GetMapping("/showCareCust")
    public ResponseBean<CustCheckInDTO> showCareCust(){
        return null;
    }

//  查询入住信息
    @GetMapping("/searchCust")
    public ResponseBean<CustCheckInDTO> searchCust(String cname,String checkInTime,String type){
        return null;
    }
//  添加入住登记
    @PostMapping("/addCust")
    public ResponseBean<Integer> addCust(CustCheckInDTO data){
        return null;
    }
}
