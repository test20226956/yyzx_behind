package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.NursingLevel;
import com.neusoft.SP01.po.NursingProject;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 对应 t_nursing_project
 */
@Mapper
public interface NursingProjectDao {
    
	/*分页搜索护理项目*/
    @Select("<script>" +
            "SELECT * FROM t_nursing_project " +
            "WHERE 1=1 " +
            "<if test='name != null and name != \"\"'> " +
            "   AND name LIKE CONCAT('%', #{name}, '%') " +
            "</if> " +
            "<if test='state != null'> " +
            "   AND state = #{state} " +
            "</if> " +
            "LIMIT #{offset}, #{pageSize}" +
            "</script>")
    List<NursingProject> searchProjects(
            @Param("name") String name,
            @Param("state") Integer state,
            @Param("offset") Long offset,
            @Param("pageSize") Long pageSize);

    /*统计符合条件的护理级别数量*/
    @Select("<script>" +
            "SELECT COUNT(*) FROM t_nursing_project " +
            "WHERE 1=1 " +
            "<if test='name != null and name != \"\"'> " +
            "   AND name LIKE CONCAT('%', #{name}, '%') " +
            "</if> " +
            "<if test='state != null'> " +
            "   AND state = #{state} " +
            "</if>" +
            "</script>")
    Long countSearchProjects(
            @Param("name") String name,
            @Param("state") Integer state);
    
    //添加护理项目
    @Insert("INSERT INTO t_nursing_project(state, time, name, price, period, description) " +
            "VALUES(#{state}, #{time}, #{name}, #{price}, #{period}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "nursingProjectId")
    int insert(NursingProject nursingProject);
    
 // 动态更新项目信息
    @Update("UPDATE t_nursing_project set state = #{state},time = #{time},"
    		+ "name = #{name},price = #{price},period = #{period},description = #{description} "
    		+ "WHERE nursing_project_id = #{nursingProjectId}")
    int updateSelective(NursingProject nursingProject);
    
    // 根据ID查询原始数据
    @Select("SELECT * FROM t_nursing_project WHERE nursing_project_id = #{projectId}")
    NursingProject selectById(Integer projectId);
    
    
    //删除项目
    @Update("update t_nursing_project set state=-1 where nursing_project_id=#{nursingProjectId}")
    int deleteNursingProject(Integer nursingProjectId);

}
