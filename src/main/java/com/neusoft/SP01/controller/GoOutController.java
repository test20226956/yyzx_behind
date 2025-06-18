package com.neusoft.SP01.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.SP01.po.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/GoOutController")
@RestController
public class GoOutController {
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
    public PageResponseBean<OutRecord> showCustGoOutRe(String custId){
        return null;
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
