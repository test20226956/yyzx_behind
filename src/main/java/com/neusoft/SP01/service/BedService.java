package com.neusoft.SP01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.BedDao;
import com.neusoft.SP01.po.Bed;
import com.neusoft.SP01.po.ResponseBean;

@Service
public class BedService {
	@Autowired
    private BedDao bd;
	public ResponseBean<List<Bed>> searchFreeBed(Integer roomId){
		try {
            // 参数校验
            if (roomId == null) {
             
                return new ResponseBean<>(500, "房间ID不能为空", null);
            }
            
            // 查询数据库
            
            List<Bed> freeBeds = bd.searchFreeBed(roomId);
            
            // 处理查询结果
            if (freeBeds == null || freeBeds.isEmpty()) {
                
                return new ResponseBean<>(500, "该房间没有空闲床位",null);
            }
            
            return new ResponseBean<>(200, "查询成功", freeBeds);
            
        } catch (Exception e) {
            
            return new ResponseBean<>(500, "系统错误，查询失败", null);
        }
		
        
	}
    
    
}