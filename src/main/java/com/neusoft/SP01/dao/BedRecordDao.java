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
    
    /* 查询所有床位记录*/
    @Select("SELECT * FROM bed_record")
    List<BedRecord> searchBedRecord();
    
    /* 根据客户姓名(模糊查询)和状态查询床位记录*/
    @Select("SELECT ")
    List<BedRecord> searchBedRecordByCondition(String customerName,Integer state);
    
    
    
    /*更新床位记录的结束时间(用于修改床位详情)*/
    @Update("UPDATE ")
    Integer updateEndTime(Integer bedRecordId,String endTime);
    
    
    
 /* ---------------------- 床位记录操作 ---------------------- */
    
    /*添加床位使用记录*/
    @Insert("INSERT ")
    Integer addBedRecord(BedRecord bedRecord);
    
    /*根据记录ID查询床位记录*/
    @Select("SELECT * FROM bed_record WHERE bed_record_id = #{bedRecordId}")
    BedRecord findBedRecordById(Integer bedRecordId);
    
    /*查询客户的所有床位记录*/
    @Select("SELECT * FROM bed_record WHERE check_in_id = #{checkInId}")
    List<BedRecord> findBedRecordsByCustomer(Integer checkInId);
    
    /*查询客户当前使用的床位记录*/
    @Select("SELECT * FROM bed_record WHERE check_in_id = #{checkInId} AND state = 1")
    BedRecord findActiveBedRecordByCustomer(Integer checkInId);
    
    /*查询床位的历史使用记录*/
    @Select("SELECT * FROM bed_record WHERE bed_id = #{bedId} AND state = 2")
    List<BedRecord> findBedHistoryRecords(Integer bedId);
    
    /*更新床位记录状态*/
    @Update("UPDATE bed_record SET state = #{state} WHERE bed_record_id = #{bedRecordId}")
    Integer updateBedRecordState(Integer bedRecordId, Integer state);
    
    /*更新床位记录的结束时间*/
    @Update("UPDATE bed_record SET end_time = #{endTime} WHERE bed_record_id = #{bedRecordId}")
    Integer updateBedRecordEndTime(Integer bedRecordId, String endTime);
    
    /*逻辑删除床位记录(将状态改为历史)*/
    @Update("UPDATE bed_record SET state = 2 WHERE bed_record_id = #{bedRecordId}")
    Integer logicalDeleteBedRecord(@Param("bedRecordId") Integer bedRecordId);

    /* ---------------------- 综合查询 ---------------------- */
    
    /*查询房间的床位使用情况(包含床位信息和客户信息)*/
    @Select("SELECT")
    List<BedUsageInfo> findBedUsageByRoom(Integer roomId);
    
    /*统计各状态床位数量(空闲、使用中、外出)*/
    @Select("SELECT ")
    BedStatistics countBedStatus();
    
    // 床位使用情况返回对象
    public static class BedUsageInfo {
        private Bed bed;
        private BedRecord bedRecord;
        private String customerName;
        // getter和setter方法
    }
    
    // 床位统计返回对象
    public static class BedStatistics {
        private Integer availableCount;  // 空闲床位数量
        private Integer inUseCount;     // 使用中床位数量
        private Integer outCount;       // 外出床位数量
        // getter和setter方法
    }
    
    
}