package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/CheckOutController")
@RestController
public class CheckOutController {
    @GetMapping("/showCheckOut")
    public PageResponseBean<CheckOutRecord> showCheckOut(){
        return null;
    }

    @GetMapping("/searchCheckOut")
    public PageResponseBean<CheckOutRecord> searchCheckOut(String custName){
        return null;
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
