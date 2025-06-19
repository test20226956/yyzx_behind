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
import com.neusoft.SP01.po.CheckInRecord;
import com.neusoft.SP01.po.Customer;
import com.neusoft.SP01.po.Room;

@Mapper
public interface BedDao {
	
	// 更新床位状态
    @Update("UPDATE t_bed SET available = 1 WHERE bed_id = #{bedId}")
    int updateBedStatus(@Param("bedId") Integer bedId);

    /* ---------------------- 床位基本信息操作 ---------------------- */
    
    /* 根据床位ID查询床位信息*/
    @Select("SELECT * FROM bed WHERE bed_id = #{bedId}")
    Bed findBedById(Integer bedId);
    
    /* 根据房间ID查询所有床位*/
    @Select("SELECT * FROM bed WHERE room_id = #{roomId}")
    List<Bed> findBedsByRoom(Integer roomId);
    
    /* 按房间号查询空闲床位*/
    @Select("SELECT * FROM t_bed WHERE available = 0 AND room_id=#{roomId}")
    List<Bed> searchFreeBed(Integer roomId);
    
    /* 根据楼层查询空闲床位*/
    @Select("SELECT ")
    List<Bed> findAvailableBedsByFloor(Integer floor);
    
    /* 更新床位可用状态*/
    @Update("UPDATE bed SET available = #{available} WHERE bed_id = #{bedId}")
    Integer updateBedAvailability(Integer bedId,Integer available);

   
}