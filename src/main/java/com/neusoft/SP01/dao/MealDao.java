package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.Meal;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 对应t_meal
 */
@Mapper
public interface MealDao {

    //获取全部食物信息
    @Select("select * from yyzx_st.t_meal")
    List<Meal> findAllMeals();
    //根据食物名称查找食物(模糊)
    @Select("select * from yyzx_st.t_meal where name like concat('%',#{name},'%')")
    List<Meal> findMealsByName(String name);
    //添加食物
    @Insert("insert into yyzx_st.t_meal values (null,#{name},#{img},#{type})")
    void addMeal(Meal meal);
    //修改食物信息
    @Update("update yyzx_st.t_meal set name=#{name},img=#{img},type=#{type} where meal_id=#{meal_id}")
    void updateMeal(Meal meal);
    //删除存在的食物
    @Delete("delete from yyzx_st.t_meal where meal_id =#{mealId}")
    void deleteMeal(Integer mealId);
}
