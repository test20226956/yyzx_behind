package com.neusoft.SP01.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

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
}
