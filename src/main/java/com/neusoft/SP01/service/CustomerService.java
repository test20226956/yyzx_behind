package com.neusoft.SP01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.CustomerDao;
import com.neusoft.SP01.po.CustCheckInDTO;
import com.neusoft.SP01.po.Customer;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;

@Service
public class CustomerService {
	@Autowired
    private CustomerDao cd;
    
	/*查自理*/
	public PageResponseBean<List<CustCheckInDTO>> getSelfCareCustomersByPage(long pageNum, long pageSize) {
        // 计算偏移量
        long offset = (pageNum - 1) * pageSize;
        
        // 查询分页数据
        List<CustCheckInDTO> list = cd.showSelfCust(offset, pageSize);
        
        // 查询总数
        long total = cd.countSelfCareCustomers();
        
        // 构建分页响应
        PageResponseBean<List<CustCheckInDTO>> response = new PageResponseBean<>();
        response.setStatus(200);
        response.setMsg("查询成功");
        response.setData(list);
        response.setTotal(total);
        
        return response;
    }
	/*查护理*/
	public PageResponseBean<List<CustCheckInDTO>> getCareCustomersByPage(long pageNum, long pageSize) {
        // 计算偏移量
        long offset = (pageNum - 1) * pageSize;
        
        // 查询分页数据
        List<CustCheckInDTO> list = cd.showCareCust(offset, pageSize);
        
        // 查询总数
        long total = cd.countCareCustomers();
        
        // 构建分页响应
        PageResponseBean<List<CustCheckInDTO>> response = new PageResponseBean<>();
        response.setStatus(200);
        response.setMsg("查询成功");
        response.setData(list);
        response.setTotal(total);
        
        return response;
    }
	/*全查*/
	public PageResponseBean<List<CustCheckInDTO>> searchCustomers(String selfCare, String name, String checkInTime, 
	        long pageNum, long pageSize) {
	    // 计算偏移量
	    long offset = (pageNum - 1) * pageSize;
	    
	    // 查询分页数据
	    List<CustCheckInDTO> list = cd.searchCustomers(
	        selfCare, 
	        name, 
	        checkInTime,
	        offset, 
	        pageSize
	    );
	    
	    // 查询总数
	    long total = cd.countSearchCustomers(
	        selfCare, 
	        name, 
	        checkInTime
	    );
	    
	    // 构建分页响应
	    PageResponseBean<List<CustCheckInDTO>> response = new PageResponseBean<>();
	    
	    // 检查查询结果
	    if (list == null || list.isEmpty()) {
	        response.setStatus(500);
	        response.setMsg("查不到符合条件的记录");
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
	
	/*查以前的老人*/
	public ResponseBean<Customer> searchCustByIdentity(String identity) {
	    // 参数校验
	    if (identity == null || identity.trim().isEmpty()) {
	        return new ResponseBean<>(500, "身份证号不能为空", null);
	    }
	    
	    // 查询数据库
	    Customer customer = cd.searchCustByIdentity(identity);
	    
	    // 判断查询结果
	    if (customer == null) {
	        return new ResponseBean<>(500, "无历史记录", null);
	    }
	    
	    return new ResponseBean<>(200, "查询成功", customer);
	}
}