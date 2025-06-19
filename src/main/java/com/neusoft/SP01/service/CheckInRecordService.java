package com.neusoft.SP01.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.SP01.dao.BedDao;
import com.neusoft.SP01.dao.BedRecordDao;
import com.neusoft.SP01.dao.CheckInRecordDao;
import com.neusoft.SP01.dao.CustomerDao;
import com.neusoft.SP01.dao.FamilyDao;
import com.neusoft.SP01.po.CustCheckInDTO;
import com.neusoft.SP01.po.ResponseBean;

@Service
public class CheckInRecordService {
	
	@Autowired
    private CustomerDao cd;
	@Autowired
    private BedDao bd;
	@Autowired
    private BedRecordDao brd;
	@Autowired
    private FamilyDao fd;
	@Autowired
    private CheckInRecordDao cird;
	
	public ResponseBean<String> addCustCheckIn(CustCheckInDTO data) {
        try {
            // 1. 参数校验
            if (data == null || data.getCustomer() == null || 
                data.getCheckInRecord() == null || data.getBedRecord() == null) {
                return new ResponseBean<>(500, "参数不完整", null);
            }
            
            // 3. 添加老人信息
            cd.insertCustomer(data.getCustomer());
            Integer customerId = data.getCustomer().getCustomerId();
            if (customerId == null) {
                throw new RuntimeException("添加老人信息失败");
            }
            
            // 4. 添加家属信息（如果有）
            if (data.getFamily() != null) {
                data.getFamily().setCustomerId(customerId);
                fd.insertFamily(data.getFamily());
            }
            
            // 5. 设置入住记录关联
            data.getCheckInRecord().setCustomerId(customerId);
            data.getCheckInRecord().setState(1); // 设置为在住状态
            
            // 6. 处理可为空字段
            if (data.getCheckInRecord().getNursingLevelId() == null) {
                data.getCheckInRecord().setNursingLevelId(0); // 设置默认值
            }
            
            if (data.getCheckInRecord().getUserId() == null) {
                data.getCheckInRecord().setUserId(0); // 设置默认值
            }
            
            // 7. 添加入住记录
            cird.insertCheckInRecord(data.getCheckInRecord());
            Integer checkInRecordId = data.getCheckInRecord().getCheckInRecordId();
            if (checkInRecordId == null) {
                throw new RuntimeException("添加入住记录失败");
            }
            
            // 8. 设置床位记录关联
            data.getBedRecord().setCheckInId(checkInRecordId);
            data.getBedRecord().setState(1); // 设置为使用中
            
            
            // 9. 添加床位记录
            brd.insertBedRecord(data.getBedRecord());
            
            // 10. 更新床位状态为已占用
            bd.updateBedStatus(data.getBedRecord().getBedId());
            
            return new ResponseBean<>(200, "添加成功", null);
            
        } catch (Exception e) {
            throw new RuntimeException("添加老人入住信息失败: " + e.getMessage());
            // 事务会自动回滚
        }
    }

}
