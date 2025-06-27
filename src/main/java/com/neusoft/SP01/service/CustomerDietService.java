package com.neusoft.SP01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.CustomerDietDao;
import com.neusoft.SP01.po.CustCheckInDietDTO;
import com.neusoft.SP01.po.CustCheckInNurseDTO;
import com.neusoft.SP01.po.PageResponseBean;

@Service
public class CustomerDietService {
	
	@Autowired
	private CustomerDietDao cdd;
	/*全查(在护理下）*/
	public PageResponseBean<List<CustCheckInDietDTO>> searchCustDiet(String name, String checkInTime, 
	        long pageNum, long pageSize) {
	    // 计算偏移量
	    long offset = (pageNum - 1) * pageSize;
	    
	    // 查询分页数据
	    List<CustCheckInDietDTO> list = cdd.searchCustomers(
	        name, 
	        checkInTime,
	        offset, 
	        pageSize
	    );
	    
	    // 查询总数
	    long total = cdd.countSearchCustomers( 
	        name, 
	        checkInTime
	    );
	    
	    // 构建分页响应
	    PageResponseBean<List<CustCheckInDietDTO>> response = new PageResponseBean<>();
	    
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
    
}