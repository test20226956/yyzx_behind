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

import com.neusoft.SP01.po.NursingService;
import com.neusoft.SP01.po.NursingServiceDTO;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.service.NursingServiceService;

@RestController
@RequestMapping("/NursingServiceController")
@CrossOrigin("*")
public class NursingServiceController {
	@Autowired
	private NursingServiceService nss;
    //设置护理级别功能
    //1.展示用户的护理服务
    @GetMapping("/showNursingPro")
    public ResponseBean<List<NursingServiceDTO>> showNursingPro( @RequestParam Integer customerId) {
        return nss.showNursingPro(customerId);
    }
    //移除护理级别联级
    @PostMapping("/deleteNursingLevel")
    public ResponseBean<Integer> deleteNursingLevel(@RequestParam Integer customerId) {
        return nss.deleteNursingLevel(customerId);
    }
    //批量添加护理项目
    @PostMapping("/batchAdd")
    public ResponseBean<Integer> batchAddNursingServices(@RequestBody List<NursingService> nursingServices) {
        return nss.batchAddNursingServices(nursingServices);
    }
    
  //给客户的项目续费
    @PostMapping("/editNursingPro")
    public ResponseBean<Integer> editNursingPro(@RequestParam Integer nursingServiceId,@RequestParam Integer amount,@RequestParam String endTime) {
    	return nss.editNursingPro(nursingServiceId,amount,endTime);
    }

    //移除护理项目
    @PostMapping("/deleteNursingPro")
    public ResponseBean<Integer> deleteNursingPro(@RequestParam Integer nursingServiceId) {
    	return nss.deleteNursingPro(nursingServiceId);
    }


    //3.设置护理级别 - 此时既需要护理级别部分更新，还需要对用户的护理服务更新
    @PostMapping("/addNursingPro")
    public ResponseBean<Integer> addNursingProject(@RequestBody NursingService projectService) {
        return nss.addNursingProject(projectService);
    }

    //服务关注

    

   

    //给用户添加护理项目 - 这时添加的护理项目可能是一个list？
    @PostMapping("/addNursingProForCust")
    public ResponseBean<Integer> addNursingProForCust(Integer custId, List<Integer> proIds) {
        return null;
    }

}
