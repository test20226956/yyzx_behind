package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.CustDietDTO;
import com.neusoft.SP01.po.CustomerDiet;
import com.neusoft.SP01.po.ResponseBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/CustDietController")
@RestController
public class CustDietController {
    //    展示所有老人的膳食配置
    @GetMapping("/showCustDiet")
//    这个CustDietInfo不是真正存储在数据库中的custDiet表对应的实体类
//    是一个用于返回前端的类
    public ResponseBean<List<CustDietDTO>> showCustDiet(){
        return null;
    }

    //    根据客户名字查找膳食配置
    @GetMapping("/searchCustDiet")
    public ResponseBean<List<CustomerDiet>> searchCustDiet(String cname){
        return null;
    }

    //    修改客户膳食配置
    @PostMapping("/editCustDiet")
    public ResponseBean<Integer> editCustDiet(CustomerDiet data){
        return null;
    }

}
