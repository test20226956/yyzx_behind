package com.neusoft.SP01.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neusoft.SP01.po.CheckInRecord;

@Mapper
public interface CheckInRecordDao {
	// 添加入住记录（nursing_level_id和user_id可为空）
    @Insert("INSERT INTO t_check_in_record(customer_id, nursing_level_id, user_id, " +
            "check_in_time, end_time, state) " +
            "VALUES(#{checkInRecord.customerId}, " +
            "#{checkInRecord.nursingLevelId,jdbcType=INTEGER}, " +
            "#{checkInRecord.userId,jdbcType=INTEGER}, " +
            "#{checkInRecord.checkInTime}, #{checkInRecord.endTime}, #{checkInRecord.state})")
    @Options(useGeneratedKeys = true, keyProperty = "checkInRecord.checkInRecordId")
    int insertCheckInRecord(@Param("checkInRecord") CheckInRecord checkInRecord);
    
 // 逻辑删除入住记录（设置状态为隐藏）
    @Update("UPDATE t_check_in_record SET state = 0 WHERE customer_id = #{customerId} AND state = 1")
    int hideCheckInRecord(@Param("customerId") Integer customerId);
    
 // 获取客户当前有效的入住记录
    @Select("SELECT * FROM t_check_in_record WHERE customer_id=#{customerId} AND state=1")
    CheckInRecord findActiveCheckInRecord(@Param("customerId") Integer customerId);
    
    /*获取客户当前有效的入住记录ID*/
    @Select("SELECT check_in_record_id FROM t_check_in_record " +
            "WHERE customer_id = #{customerId} AND state = 1") // state=1表示有效入住
    Integer findActiveCheckInId(@Param("customerId") Integer customerId);
    
    /*更新入住记录状态为0（退住）*/
    @Update("UPDATE t_check_in_record SET state = 0 WHERE check_in_record_id = #{checkInRecordId}")
    int updateCheckInToInactive(@Param("checkInRecordId") Integer checkInRecordId);
    
    // 更新入住记录的结束时间
    @Update("UPDATE t_check_in_record SET end_time=#{endTime} WHERE check_in_record_id=#{checkInRecordId}")
    int updateEndTime(@Param("checkInRecordId") Integer checkInRecordId, 
                    @Param("endTime") String endTime);
    
    /*获取入住记录关联的床位记录ID*/
    @Select("SELECT bed_record_id FROM t_bed_record " +
            "WHERE check_in_record_id = #{checkInRecordId} AND state = 1")
    Integer findActiveBedRecordId(@Param("checkInRecordId") Integer checkInRecordId);
    
    @Select("SELECT * FROM t_check_in_record WHERE customer_id = #{customerId} AND state = 1")
    CheckInRecord findByCustomerId(@Param("customerId") Integer customerId);
}
