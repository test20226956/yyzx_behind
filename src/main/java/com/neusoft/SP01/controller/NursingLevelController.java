package com.neusoft.SP01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.SP01.po.NursingLevel;
import com.neusoft.SP01.po.NursingProject;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.service.NursingLevelService;

@RestController
@RequestMapping("/NursingLevelController")
@CrossOrigin("*")
public class NursingLevelController {
	@Autowired
	private NursingLevelService nls;
	//显示及查询
	@GetMapping("/searchNursingLevel")
    public PageResponseBean<List<NursingLevel>> searchLevels(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer state,
            @RequestParam(defaultValue = "1") Long pageNum,
            @RequestParam(defaultValue = "10") Long pageSize) {
        
        return nls.searchLevels(name, state, pageNum, pageSize);
    }
	
	//添加护理级别信息
    @PostMapping("/addNursingLevel")
    public ResponseBean<Integer> addNursingLevel(@RequestBody NursingLevel nursingLevel) {
        return nls.addNursingLevel(nursingLevel);
    }
    //删除护理级别及其下的项目
    @PostMapping("/deleteNursingLevel")
    public ResponseBean<Integer> deleteNursingLevel(@RequestParam Integer nursingLevelId) {
        return nls.deleteNursingLevel(nursingLevelId);
    }
    

    //修改护理级别 —— 只修改状态
    @PostMapping("/editNursingLevel")
    public ResponseBean<Integer> editNursingLevel(NursingLevel nursingLevel) {
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
