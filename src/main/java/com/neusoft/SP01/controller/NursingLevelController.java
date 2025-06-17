package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.NursingLevel;
import com.neusoft.SP01.po.NursingProject;
import com.neusoft.SP01.po.ResponseBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NursingLevelController")
@CrossOrigin("*")
public class NursingLevelController {

    // 展示和查询项目，别忘记分页
    // 展示所有护理级别，默认只显示启用的
    @GetMapping("/showNursingLevel")
    public ResponseBean<List<NursingLevel>> showNursingLevel(Long cur,Long pageSize) {
        return null;
    }

    //按照级别名称和状态查询级别
    @GetMapping("/searchNursingLevel")
    public ResponseBean<List<NursingLevel>> searchNursingLevel(String name, Integer state, Long cur,Long pageSize) {
        return null;
    }

    //修改护理级别 —— 只修改状态
    @PostMapping("/editNursingLevel")
    public ResponseBean<Integer> editNursingLevel(NursingLevel nursingLevel) {
        return null;
    }

    //添加护理级别信息
    @PostMapping("/addNursingLevel")
    public ResponseBean<Integer> addNursingLevel(NursingLevel nursingLevel) {
        return null;
    }

    //删除护理级别下的项目
    @PostMapping("/deleteNursingPro")
    public ResponseBean<Integer> deleteNursingPro(Integer levelId, Integer proId) {
        return null;
    }

    //给护理级别添加项目
    @PostMapping("/addNursingPro")
    public ResponseBean<Integer> addNursingPro(Integer proId) {
        return null;
    }

    //根据护理级别返回项目
    @GetMapping("/showNursingPro")
    public ResponseBean<List<NursingProject>> showNursingProByLv(Integer levelId){
        return null;
    }

    //展示护理级别下所有未包括的项目
    @GetMapping("/showUnNursingPro")
    public ResponseBean<List<NursingProject>> showUnNursingPro(Integer levelId) {
        return null;
    }

    //搜索级别下未添加的项目
    @GetMapping("/searchUnNursingPro")
    public ResponseBean<List<NursingProject>> searchUnNursingPro(Integer levelId, String proName) {
        return null;
    }

    //搜索级别下添加的项目
    @GetMapping("/searchNursingPro")
    public ResponseBean<List<NursingProject>> searchNursingPro(Integer levelId, String proName) {
        return null;
    }

}
