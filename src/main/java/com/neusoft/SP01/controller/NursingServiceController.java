package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.NursingService;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NursingServiceController")
@CrossOrigin("*")
public class NursingServiceController {
    //设置护理级别功能
    //1.展示用户的护理服务 - 不对 还得改
    @GetMapping("/showCustPro")
    public PageResponseBean<List<NursingService>> showCustPro(Integer custId, Long cur, Long pageSize) {
        return null;
    }

    //2.为了给用户设置级别，要先获取都有什么级别，放到下拉框中
    //2.1获取护理级别 这可以直接复用

    //2.2展示级别下的项目 这可以直接复用

    //3.设置护理级别 - 此时既需要护理级别部分更新，还需要对用户的护理服务更新
    @PostMapping("/addNursingPro")
    public ResponseBean<Integer> addNursingPro(List<NursingService> nursingServiceList) {
        return null;
    }


}
