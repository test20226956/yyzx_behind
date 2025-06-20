package com.neusoft.SP01.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.SP01.dao.OutRecordDao;
import com.neusoft.SP01.po.CustOutRecordDTO;
import com.neusoft.SP01.po.PageResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.UserDao;
import com.neusoft.SP01.po.ResponseBean;
import com.neusoft.SP01.po.User;

import java.util.List;

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
    
}