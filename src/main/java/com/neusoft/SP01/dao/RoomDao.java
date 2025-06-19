package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.Bed;
import com.neusoft.SP01.po.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 对应t_room
 */
@Mapper
public interface RoomDao {
    //查询楼层所有可使用房间
    @Select("select * from t_room where floor=#{floor}")
    List<Room> findRooms(Integer floor);
    
    //根据房间号获得具体房间的床位信息(是写在Room还是Bed里面？)
    List<Bed> findBedsByRoom(Integer roomNumber);
}
