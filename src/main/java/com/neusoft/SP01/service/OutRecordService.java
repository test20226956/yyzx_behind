package com.neusoft.SP01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.SP01.dao.OutRecordDao;
import com.neusoft.SP01.po.CheckOutRecordWithName;
import com.neusoft.SP01.po.CustOutRecordDTO;
import com.neusoft.SP01.po.OutRecordWithName;
import com.neusoft.SP01.po.PageResponseBean;

@Service
public class OutRecordService {
    @Autowired
    OutRecordDao ord;
    //根据老人查找对应的外出申请(外出申请功能页面中点击老人的申请记录)
    public PageResponseBean<List<CustOutRecordDTO>> findOutRecordByCustomerId(Integer pageNum,Integer pageSize,Integer customerId){
        //设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        //执行查询
        List<CustOutRecordDTO> cords = ord.findOutRecordByCustomerId(customerId);
        // 3. 获取分页信息
        Page<CustOutRecordDTO> p =(Page<CustOutRecordDTO>)cords;
        // 4. 构建响应对象
        PageResponseBean<List<CustOutRecordDTO>> response = new PageResponseBean<>();
        response.setStatus(200); // 成功状态码
        response.setMsg("success"); // 成功消息
        response.setData(p.getResult()); // 当前页数据
        response.setTotal(p.getTotal()); // 总记录数
        return response;
    }
    
 // 展示所有退住申请（分页）
    public PageResponseBean<List<OutRecordWithName>> showGoOut(long pageNum, long pageSize) {
    	//计算偏移量
        long offset = (pageNum - 1) * pageSize;
        
        // 查询分页数据（现在返回带姓名的结果）
        List<OutRecordWithName> list = ord.showGoOut(offset, pageSize);
        
        // 查询总数
        long total = ord.countGoOut();
        
        // 构建分页响应
        PageResponseBean<List<OutRecordWithName>> response = new PageResponseBean<>();
        if (list == null || list.isEmpty()) {
	        response.setStatus(500);
	        response.setMsg("无数据");
	        response.setData(null);
	        response.setTotal(0);
	    } else {
	        response.setStatus(200);
	        response.setMsg("查询成功");
	        response.setData(list);
	        response.setTotal(total);
	    }
        
        return response;
        
    }
    
  //条件查询（分页）
    public PageResponseBean<List<OutRecordWithName>> queryGoOut(
            String customerName, 
            Integer state,
            String applyTime,
            long pageNum, 
            long pageSize) {
        
        long offset = (pageNum - 1) * pageSize;
        List<OutRecordWithName> list = ord.queryByConditions(
                customerName, state,applyTime, offset, pageSize);
        long total = ord.countByConditions(customerName, state,applyTime);
        
        PageResponseBean<List<OutRecordWithName>> response = new PageResponseBean<>();
        if (list == null || list.isEmpty()) {
	        response.setStatus(500);
	        response.setMsg("无数据");
	        response.setData(null);
	        response.setTotal(0);
	    } else {
	        response.setStatus(200);
	        response.setMsg("查询成功");
	        response.setData(list);
	        response.setTotal(total);
	    }
        
        return response;
    }
    
}