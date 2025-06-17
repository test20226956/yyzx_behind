package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.NursingRecord;
import com.neusoft.SP01.po.NursingRecordDTO;
import com.neusoft.SP01.po.ResponseBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NursingRecordController")
@CrossOrigin("*")
public class NursingRecordController {

    //根据客户id得到护理记录
    @GetMapping("/showNursingRecord")
    public ResponseBean<List<NursingRecordDTO>> showNursingRecord(Integer custId) {
        return null;
    }

    //删除护理记录
    @PostMapping("/deleteNursingRecord")
    public ResponseBean<Integer> deleteNursingRecord(Integer recordId) {
        return null;
    }
}
