package com.neusoft.SP01.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.neusoft.SP01.dao.NursingRecordDao;
import com.neusoft.SP01.dao.NursingServiceDao;
import com.neusoft.SP01.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class NursingRecordService {
    @Autowired
    private NursingRecordDao nrd;
    @Autowired
    private NursingServiceDao nsd;
    //添加老人护理记录
    @Transactional
    public boolean addNursingRecord(NursingRecord nr){
        nrd.addNursingRecord(nr);// 插入护理记录
        nsd.updateNursingServiceAmount(nr.getCount(),nr.getNursingServiceId());//// 更新剩余服务次数
        return true;
    }
    //展示老人所有的护理记录（护工 健康管家 护理记录）
    public PageResponseBean<List<CustNursingRecordDTO>> findByCustomerId(Integer pageNum, Integer pageSize, Integer customerId){
        //设置分页参数
        PageHelper.startPage(pageNum, pageSize);
        //执行查询
        List<CustNursingRecordDTO> cords = nrd.findByCustomerId(customerId);
        // 3. 获取分页信息
        Page<CustNursingRecordDTO> p =(Page<CustNursingRecordDTO>)cords;
        // 4. 构建响应对象
        PageResponseBean<List<CustNursingRecordDTO>> response = new PageResponseBean<>();
        if(p.getTotal()!=0){
            response.setStatus(200); // 成功状态码
            response.setMsg("查询成功"); // 成功消息
            response.setData(p.getResult()); // 当前页数据
            response.setTotal(p.getTotal()); // 总记录数
        }else{
            response.setStatus(500); // 成功状态码
            response.setMsg("无数据"); // 成功消息
            response.setData(p.getResult()); // 当前页数据
            response.setTotal(p.getTotal()); // 总记录数
        }
        return response;
    }
    //逻辑删除老人的护理记录
    public boolean deleteByIds(List<Integer> ids){
        nrd.deleteByIds(ids);
        return true;
    }
    
}