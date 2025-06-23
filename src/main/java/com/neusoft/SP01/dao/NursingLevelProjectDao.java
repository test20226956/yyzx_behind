package com.neusoft.SP01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NursingLevelProjectDao {
	
	//删除护理级别
	@Update("UPDATE t_nursing_level_project " +
            "SET state = 0 " +
            "WHERE nursing_level_id = #{nursingLevelId}")
    int updateStateByLevelId(@Param("nursingLevelId") Integer nursingLevelId);
	
}
