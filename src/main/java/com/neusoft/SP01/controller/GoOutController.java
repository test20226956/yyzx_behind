package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.CheckOutRecord;
import com.neusoft.SP01.po.CustCheckInDTO;
import com.neusoft.SP01.po.OutRecord;
import com.neusoft.SP01.po.ResponseBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RequestMapping("/GoOutController")
@RestController
public class GoOutController {
    @GetMapping("/showGoOut")
    public ResponseBean<OutRecord> showGoOut(){
        return null;
    }

    @GetMapping("/searchGoOut")
    public ResponseBean<OutRecord> searchGoOut(String custName){
        return null;
    }
    @GetMapping("/checkGoOut")
    public ResponseBean<Integer> goCheckOut(String goOutId, Integer state){
        return null;
    }
}
