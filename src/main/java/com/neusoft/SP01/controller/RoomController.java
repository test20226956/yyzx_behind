package com.neusoft.SP01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.Room;
import com.neusoft.SP01.service.RoomService;

@CrossOrigin("/*")
@RestController
@RequestMapping("/RoomController")
public class RoomController {
	
	@Autowired  // 确保正确注入
    private RoomService rs;
	
//    查询楼层所有房间
    @GetMapping("/searchRoom")
    public ResponseBean<List<Room>> searchRoom(Integer floor){
        return rs.searchRoom(floor);
    }
}
