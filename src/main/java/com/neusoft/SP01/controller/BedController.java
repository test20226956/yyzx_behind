package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/BedController")
@RestController
public class BedController {

    //    获得该楼层的床位统计数据
    @GetMapping("/searchBedSta")
    public ResponseBean<BedSta> searchBedSta(Integer floor) {
        return null;
    }

    //    根据房间号获取房间的床位信息
    @GetMapping("/searchBedByRoom")
    public ResponseBean<List<Bed>> searchBedByRoom(Integer roomId) {
        return null;
    }

    //    根据房间号获取可使用的床位
    @GetMapping("/searchFreeBed")
    public ResponseBean<List<Bed>> searchFreeBed(Integer roomId) {
        return null;
    }

    //    显示所有床位使用记录（根据状态是否为当前使用返回对应的记录）(分页)
    @GetMapping("/showAllBedRecord")
    public PageResponseBean<List<CustBedDTO>> showAllBedRecord(Integer state,long cur,long pageSize) {
        return null;
    }

    //    根据客户姓名查询使用记录
    @GetMapping("/searchBedRecord")
    public PageResponseBean<List<CustBedDTO>> searchBedRecord(String cname, Integer state, String startTime,long cur,long pageSize) {
        return null;
    }

    //    修改客户床位信息
    @PostMapping("/editBedRecord")
    public ResponseBean<Integer> editBedRecord(BedRecord data) {
        return null;
    }
}
