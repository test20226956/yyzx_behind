package com.neusoft.SP01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.CustomerDao;
import com.neusoft.SP01.po.CustCheckInDTO;
import com.neusoft.SP01.po.PageResponseBean;

@Service
public class CustomerService {
	@Autowired
    private CustomerDao customerDao;
    
	public PageResponseBean<List<CustCheckInDTO>> getSelfCareCustomersByPage(long pageNum, long pageSize) {
        // 计算偏移量
        long offset = (pageNum - 1) * pageSize;
        
        // 查询分页数据
        List<CustCheckInDTO> list = customerDao.showSelfCust(offset, pageSize);
        
        // 查询总数
        long total = customerDao.countSelfCareCustomers();
        
        // 构建分页响应
        PageResponseBean<List<CustCheckInDTO>> response = new PageResponseBean<>();
        response.setStatus(200);
        response.setMsg("查询成功");
        response.setData(list);
        response.setTotal(total);
        
        return response;
    }
	public PageResponseBean<List<CustCheckInDTO>> getCareCustomersByPage(long pageNum, long pageSize) {
        // 计算偏移量
        long offset = (pageNum - 1) * pageSize;
        
        // 查询分页数据
        List<CustCheckInDTO> list = customerDao.showCareCust(offset, pageSize);
        
        // 查询总数
        long total = customerDao.countCareCustomers();
        
        // 构建分页响应
        PageResponseBean<List<CustCheckInDTO>> response = new PageResponseBean<>();
        response.setStatus(200);
        response.setMsg("查询成功");
        response.setData(list);
        response.setTotal(total);
        
        return response;
    }
}