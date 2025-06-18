package com.neusoft.SP01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neusoft.SP01.po.DietCycle;
import com.neusoft.SP01.po.DietCycleDetail;

@Mapper
public interface DietCycleDao {

    /* ---------------------- 基础CRUD操作 ---------------------- */
    
    /*添加膳食周期安排*/
    @Insert("INSERT ")
    Integer addDietCycle(DietCycle dietCycle);
    
    /*根据ID查询膳食周期安排*/
    @Select("SELECT * FROM diet_cycle WHERE diet_cycle_id = #{dietCycleId}")
    DietCycle findDietCycleById(@Param("dietCycleId") Integer dietCycleId);
    
    /*更新膳食周期安排*/
    @Update("UPDATE diet_cycle SET date = #{date}, meal_id = #{mealId}, " +
            "type = #{type} WHERE diet_cycle_id = #{dietCycleId}")
    Integer updateDietCycle(DietCycle dietCycle);
    
    /*删除膳食周期安排*/
    @Delete("DELETE FROM diet_cycle WHERE diet_cycle_id = #{dietCycleId}")
    Integer deleteDietCycle(@Param("dietCycleId") Integer dietCycleId);

    
    
    /*根据日期查询膳食安排*/
    @Select("SELECT * FROM diet_cycle WHERE date = #{date}")
    List<DietCycle> findDietCyclesByDate(@Param("date") String date);
    
    /*根据日期范围查询膳食安排*/
    @Select("SELECT * FROM diet_cycle WHERE date BETWEEN #{startDate} AND #{endDate}")
    List<DietCycle> findDietCyclesByDateRange(String startDate,String endDate);
    
    /*根据餐次类型查询膳食安排*/
    @Select("SELECT * FROM diet_cycle WHERE type = #{type}")
    List<DietCycle> findDietCyclesByType(Integer type);
    
    /*查询特定日期的特定餐次膳食安排*/
    @Select("SELECT * FROM diet_cycle WHERE date = #{date} AND type = #{type}")
    DietCycle findDietCycleByDateAndType(String date,Integer type);
    
    /*查询包含特定食物的膳食周期安排*/
    @Select("SELECT * FROM diet_cycle WHERE meal_id = #{mealId}")
    List<DietCycle> findDietCyclesByMeal(@Param("mealId") Integer mealId);

    
    /*查询膳食周期详情(关联食物信息)*/
    @Select("SELECT")
    DietCycleDetail findDietCycleDetailById(Integer dietCycleId);
    
    /*查询日期范围内的膳食周期详情列表*/
    @Select("SELECT ")
    List<DietCycleDetail> findDietCycleDetailsByDateRange(String startDate,String endDate);


    
}