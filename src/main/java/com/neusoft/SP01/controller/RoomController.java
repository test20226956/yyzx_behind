package com.neusoft.SP01.controller;

import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.Room;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("/*")
@RestController
@RequestMapping("/RoomController")
public class RoomController {
//    查询楼层所有可使用?房间
    @GetMapping("/searchRoom")
    public ResponseBean<Room> searchRoom(Integer floor){
        return null;
    }
}
