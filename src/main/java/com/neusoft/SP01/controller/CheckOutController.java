package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.CheckOutRecord;
import com.neusoft.SP01.po.CustCheckInDTO;
import com.neusoft.SP01.po.ResponseBean;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/CheckOutController")
@RestController
public class CheckOutController {
    @GetMapping("/showCheckOut")
    public ResponseBean<CheckOutRecord> showCheckOut(){
        return null;
    }

    @GetMapping("/searchCheckOut")
    public ResponseBean<CheckOutRecord> searchCheckOut(String custName){
        return null;
    }
    @PostMapping("/checkCheckOut")
    public ResponseBean<Integer> checkCheckOut(String checkOutId, Integer state){
        return null;
    }
}
