package com.neusoft.SP01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.neusoft.SP01.po.Bed;
import com.neusoft.SP01.po.BedRecord;
import com.neusoft.SP01.po.CustCheckInDTO;

@Mapper
public interface BedRecordDao {
	// 添加床位记录
    @Insert("INSERT INTO t_bed_record(bed_id, check_in_record_id, state, start_time,end_time) " +
            "VALUES(#{bedRecord.bedId}, #{bedRecord.checkInRecordId}, " +
            "#{bedRecord.state}, #{bedRecord.startTime}, #{bedRecord.endTime})")
    int insertBedRecord(@Param("bedRecord") BedRecord bedRecord);
    
    // 获取客户当前显示的床位记录
    @Select("SELECT * FROM t_bed_record WHERE check_in_record_id = " +
            "(SELECT check_in_record_id FROM t_check_in_record " +
            "WHERE customer_id = #{customerId}) " +
            "AND state = 1 LIMIT 1")
    BedRecord findActiveBedRecordByCustomer(@Param("customerId") Integer customerId);
    
    // 逻辑删除床位记录（设置状态为隐藏）
    @Update("UPDATE t_bed_record SET state = 0 WHERE bed_record_id = #{bedRecordId}")
    int hideBedRecord(@Param("bedRecordId") Integer bedRecordId);
    
 // 获取当前有效的床位记录
    @Select("SELECT * FROM t_bed_record WHERE check_in_record_id=#{checkInRecordId} AND state=1")
    BedRecord findActiveBedRecord(@Param("checkInId") Integer checkInRecordId);
    
    // 更新床位记录的结束时间
    @Update("UPDATE t_bed_record SET end_time=#{endTime} WHERE bed_record_id=#{bedRecordId}")
    int updateBedEndTime(@Param("bedRecordId") Integer bedRecordId, 
                       @Param("endTime") String endTime);
    
    
	
    
    /* 查询所有床位记录*/
    @Select("SELECT * FROM bed_record")
    List<BedRecord> searchBedRecord();
    
    
    
    
}