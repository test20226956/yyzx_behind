package com.neusoft.SP01.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.SP01.dao.BedRecordDao;
import com.neusoft.SP01.dao.CheckInRecordDao;
import com.neusoft.SP01.dao.CustomerDao;
import com.neusoft.SP01.po.BedRecord;
import com.neusoft.SP01.po.CheckInRecord;
import com.neusoft.SP01.po.CustCheckInDTO;
import com.neusoft.SP01.po.Customer;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;

@Service
@Transactional(rollbackFor = Exception.class) // 添加此注解
public class CustomerService {
	@Autowired
    private CustomerDao cd;
	@Autowired
    private CheckInRecordDao cird;
    @Autowired
    private BedRecordDao brd;
    private static final Logger log = LoggerFactory.getLogger(CheckInRecordService.class);
    
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
	
	//更新
	public ResponseBean<Integer> editCust(Customer data, String endTime) {
	    try {
	        // 1. 参数校验
	        if (data == null || data.getCustomerId() == null) {
	            return new ResponseBean<>(500, "客户ID不能为空", null);
	        }
	        
	        // 2. 更新客户基本信息
	        int updated = cd.updateCustomer(data);
	        if (updated == 0) {
	            return new ResponseBean<>(500, "未找到该客户", null);
	        }
	        
	        // 3. 处理合同到期时间（如果提供了endTime）
	        if (endTime != null && !endTime.isEmpty()) {
	            // 获取当前有效的入住记录
	            CheckInRecord activeRecord = cird.findActiveCheckInRecord(data.getCustomerId());
	            if (activeRecord != null) {
	                // 总是更新入住记录结束时间
	                cird.updateEndTime(activeRecord.getCheckInRecordId(), endTime);
	                
	                // 更新关联的床位记录（只有当新结束时间早于原结束时间时才更新）
	                BedRecord bedRecord = brd.findActiveBedRecord(activeRecord.getCheckInRecordId());
	                if (bedRecord != null && bedRecord.getEndTime() != null) {
	                    LocalDate originalBedEndDate = LocalDate.parse(bedRecord.getEndTime());
	                    LocalDate newEndDate = LocalDate.parse(endTime);
	                    
	                    if (newEndDate.isBefore(originalBedEndDate)) {
	                        brd.updateBedEndTime(bedRecord.getBedRecordId(), endTime);
	                    }
	                }
	            }
	        }
	        
	        return new ResponseBean<>(200, "更新成功", 1);
	        
	    } catch (Exception e) {
	        log.error("编辑客户信息失败，客户ID: {}", data != null ? data.getCustomerId() : "null", e);
	        return new ResponseBean<>(500, "更新失败: " + e.getMessage(), null);
	    }
	}
}