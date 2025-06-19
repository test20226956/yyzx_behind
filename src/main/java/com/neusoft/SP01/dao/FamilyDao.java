package com.neusoft.SP01.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.SP01.po.Family;
@Mapper
public interface FamilyDao {
	@Insert("INSERT INTO t_family(customer_id, name, relation, tel) " +
            "VALUES(#{family.customerId}, #{family.name}, #{family.relation}, #{family.tel})")
    int insertFamily(@Param("family") Family family);
}
