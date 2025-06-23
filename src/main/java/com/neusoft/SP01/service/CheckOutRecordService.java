package com.neusoft.SP01.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.SP01.dao.BedDao;
import com.neusoft.SP01.dao.BedRecordDao;
import com.neusoft.SP01.dao.CheckInRecordDao;
import com.neusoft.SP01.dao.CheckOutRecordDao;
import com.neusoft.SP01.po.CheckOutDetailDTO;
import com.neusoft.SP01.po.CheckOutRecordWithName;
import com.neusoft.SP01.po.PageResponseBean;
import com.neusoft.SP01.po.ResponseBean;
@Service
@Transactional(rollbackFor = Exception.class) // 添加事务注解，任何异常都会回滚
public class CheckOutRecordService {
    
	@Autowired
    private CheckOutRecordDao cord;
	@Autowired
    private CheckInRecordDao cird;
	@Autowired
    private BedRecordDao brd;
	@Autowired
    private BedDao bd;
	private static final Logger log = LoggerFactory.getLogger(CheckOutRecordService.class);

    // 展示所有退住申请（分页）
    public PageResponseBean<List<CheckOutRecordWithName>> showCheckOut(long pageNum, long pageSize) {
    	//计算偏移量
        long offset = (pageNum - 1) * pageSize;
        
        // 查询分页数据（现在返回带姓名的结果）
        List<CheckOutRecordWithName> list = cord.showCheckOut(offset, pageSize);
        
        // 查询总数
        long total = cord.countCheckOut();
        
        // 构建分页响应
        PageResponseBean<List<CheckOutRecordWithName>> response = new PageResponseBean<>();
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
    public PageResponseBean<List<CheckOutRecordWithName>> queryCheckOut(
            String customerName, 
            Integer state,
            String applyTime,
            long pageNum, 
            long pageSize) {
        
        long offset = (pageNum - 1) * pageSize;
        List<CheckOutRecordWithName> list = cord.queryByConditions(
                customerName, state,applyTime, offset, pageSize);
        long total = cord.countByConditions(customerName, state,applyTime);
        
        PageResponseBean<List<CheckOutRecordWithName>> response = new PageResponseBean<>();
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
    
    
    public ResponseBean<Integer> approveCheckOut(Integer checkOutRecordId, Integer state, Integer adminId) {
        try {
            // 1. 参数校验
            if (checkOutRecordId == null || state == null || adminId == null) {
                return new ResponseBean<>(500, "参数不完整", null);
            }
            
            // 2. 获取当前日期
            String currentDate = LocalDate.now().toString();
            
            // 3. 执行审批操作
            int result = cord.approveCheckOut(checkOutRecordId, state, adminId, currentDate);
            
            if (result == 0) {
                return new ResponseBean<>(500, "未找到该退住申请", null);
            }
            
            // 4. 如果审批通过(state=1)，处理级联状态
            if (state == 1) {
                // 4.1 获取客户ID
                Integer customerId = cord.findCustomerIdByCheckOutId(checkOutRecordId);
                if (customerId == null) {
                    throw new RuntimeException("未找到关联客户");
                }
                
                // 4.2 获取当前有效入住记录
                Integer checkInRecordId = cird.findActiveCheckInId(customerId);
                if (checkInRecordId != null) {
                    // 4.3 更新入住记录状态为0(退住)
                    cird.updateCheckInToInactive(checkInRecordId);
                    // 更新入住记录的结束时间
                    cird.updateEndTime(checkInRecordId, currentDate);
                    
                    // 4.4 获取关联床位记录
                    Integer bedRecordId = cird.findActiveBedRecordId(checkInRecordId);
                    if (bedRecordId != null) {
                        // 4.5 更新床位记录状态为0(可用)
                        brd.hideBedRecord(bedRecordId);
                        // 更新床位记录的结束时间
                        brd.updateBedEndTime(bedRecordId, currentDate);
                        
                        // 4.6 更新实际床位状态为可用
                        bd.updatePhysicalBedStatus(bedRecordId);
                    }else {
                    	throw new RuntimeException("未找到相关床位记录");
                    }
                }else {
                	throw new RuntimeException("未找到相关入住记录");
                }
            }
            
            return new ResponseBean<>(200, "审批成功", result);
            
        } catch (Exception e) {
            log.error("退住审批失败，已回滚所有操作，退住记录ID：{}", checkOutRecordId, e);
            return new ResponseBean<>(500, "审批失败: " + e.getMessage(), null);
        }
    }
    
    //退住详细信息
    public ResponseBean<CheckOutDetailDTO> getCheckOutDetail(Integer checkOutRecordId) {
        CheckOutDetailDTO detail = cord.getCheckOutDetailById(checkOutRecordId);
        
        if (detail == null) {
            return new ResponseBean<>(500, "未找到有效的退住记录或入住信息");
        }
        
        // 计算年龄（已在setIdentity中自动计算）
        // 清除敏感信息（不返回身份证号给前端）
        detail.setIdentity(null);
        
        return new ResponseBean<>(200,"查询成功",detail);
    }
    
}