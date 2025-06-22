package com.neusoft.SP01.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.SP01.dao.NursingServiceDao;
import com.neusoft.SP01.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.UserDao;

import java.util.List;

@Service
public class NursingServiceService {
    @Autowired
    private NursingServiceDao nsd;
    /*======对应原型护工 日常护理 显示用户的护理服务=====*/
    public PageResponseBean<List<NursingServiceDailyDTO>> findNursingServiceByCustomerId(Integer pageNum, Integer pageSize, Integer customerId){
        //设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        //执行查询
        List<NursingServiceDailyDTO> cords = nsd.findNursingServiceByCustomerId(customerId);
        // 3. 获取分页信息
        Page<NursingServiceDailyDTO> p =(Page<NursingServiceDailyDTO>)cords;
        // 4. 构建响应对象
        PageResponseBean<List<NursingServiceDailyDTO>> response = new PageResponseBean<>();
        response.setStatus(200); // 成功状态码
        response.setMsg("查询成功"); // 成功消息
        response.setData(p.getResult()); // 当前页数据
        response.setTotal(p.getTotal()); // 总记录数
        return response;
    }
    //对应原型护工 日常护理  按项目名字搜索用户的持有的护理服务
    public PageResponseBean<List<NursingServiceDailyDTO>> findNursingServiceByName(Integer pageNum, Integer pageSize, Integer customerId,String name){
        //设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        //执行查询
        List<NursingServiceDailyDTO> cords = nsd.findNursingServiceByName(customerId,name);
        // 3. 获取分页信息
        Page<NursingServiceDailyDTO> p =(Page<NursingServiceDailyDTO>)cords;
        // 4. 构建响应对象
        PageResponseBean<List<NursingServiceDailyDTO>> response = new PageResponseBean<>();
        response.setStatus(200); // 成功状态码
        response.setMsg("查询成功"); // 成功消息
        response.setData(p.getResult()); // 当前页数据
        response.setTotal(p.getTotal()); // 总记录数
        return response;
    }
    
}