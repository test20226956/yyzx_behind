package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NursingServiceController")
@CrossOrigin("*")
public class NursingServiceController {
    //设置护理级别功能
    //1.展示用户的护理服务
    @GetMapping("/showCustPro")
    public PageResponseBean<List<NursingServiceDTO>> showCustPro(Integer custId, Long cur, Long pageSize) {
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

    //服务关注

    //给客户的项目续费
    //这里其实前端的数据类型应该是NursingServiceDTO
    @PostMapping("/editNursingPro")
    public ResponseBean<Integer> editNursingPro(NursingServiceDTO nursingServiceDTO) {
        return null;
    }

    //移除护理项目
    @PostMapping("/deleteNursingPro")
    public ResponseBean<Integer> deleteNursingPro(Integer nursingServiceId) {
        return null;
    }

    //给用户添加护理项目 - 这时添加的护理项目可能是一个list？
    @PostMapping("/addNursingProForCust")
    public ResponseBean<Integer> addNursingProForCust(Integer custId, List<Integer> proIds) {
        return null;
    }

}
