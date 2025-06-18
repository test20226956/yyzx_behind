package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.NursingProject;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NursingProjectController")
@CrossOrigin("*")
public class NursingProjectController {

    // 护理项目
    // 展示所有护理项目 (默认是搜索启用的）
    @GetMapping("/showNursingPro")
    public PageResponseBean<List<NursingProject>> showNursingPro(Long cur, Long pageSize){
        return null;
    }

    // 搜索项目 - 根据状态和名称搜索
    @GetMapping("/shearchNursingPro")
    public PageResponseBean<List<NursingProject>> searchNursingPro(NursingProject nursingPro, Long cur,Long pageSize){
        return null;
    }

    // 添加护理项目
    @PostMapping("/addNursingPro")
    public ResponseBean<Integer> addNursingPro(NursingProject nursingPro){
        return null;
    }

    // 编辑项目 - 当启用变禁用时，级别下的这个项目要被隐藏
    @PostMapping("/editNursingPro")
    public ResponseBean<Integer> editNursingPro(NursingProject nursingPro){
        return null;
    }

    // 删除现有项目
    @PostMapping("/deleteNursingPro")
    public ResponseBean<Integer> deleteNursingPro(Integer proId){
        return null;
    }


    //服务关注部分

    // 显示用户未购买的护理项目
    @GetMapping("/showUnNursingPro")
    public ResponseBean<List<NursingProject>> showUnNursingPro(Integer custId){
        return null;
    }

    // 搜索项目（非分页）
    @GetMapping("/searchNursingPro")
    public ResponseBean<List<NursingProject>> searchNursingPro(String name){
        return null;
    }
    


}
