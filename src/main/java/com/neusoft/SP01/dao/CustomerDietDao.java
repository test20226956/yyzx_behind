package com.neusoft.SP01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neusoft.SP01.po.CustomerDiet;

@Mapper
public interface CustomerDietDao {

    /*添加客户膳食配置*/
    @Insert("INSERT INTO customer_diet(customer_id, flaver, restraint, comment) " +
            "VALUES(#{customerId}, #{flaver}, #{restraint}, #{comment})")
    Integer addCustomerDiet(CustomerDiet customerDiet);

    /*根据ID查询客户膳食配置*/
    @Select("SELECT * FROM customer_diet WHERE customer_diet_id = #{customerDietId}")
    CustomerDiet findCustomerDietById(Integer customerDietId);

    /*根据客户ID查询膳食配置*/
    @Select("SELECT * FROM customer_diet WHERE customer_id = #{customerId}")
    CustomerDiet findCustomerDietByCustomerId(Integer customerId);

    /*查询所有客户膳食配置*/
    @Select("SELECT * FROM customer_diet")
    List<CustomerDiet> findAllCustomerDiets();

    /*更新客户膳食配置*/
    @Update("UPDATE customer_diet SET flaver = #{flaver}, restraint = #{restraint}, " +
            "comment = #{comment} WHERE customer_diet_id = #{customerDietId}")
    Integer updateCustomerDiet(CustomerDiet customerDiet);

    /*根据ID删除客户膳食配置*/
    @Delete("DELETE FROM customer_diet WHERE customer_diet_id = #{customerDietId}")
    Integer deleteCustomerDiet(Integer customerDietId);

    /*根据客户ID删除膳食配置*/
    @Delete("DELETE FROM customer_diet WHERE customer_id = #{customerId}")
    Integer deleteCustomerDietByCustomer(Integer customerId);

    
}