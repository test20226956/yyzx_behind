package com.neusoft.SP01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neusoft.SP01.po.CheckOutRecord;

@Mapper
public interface CheckOutRecordDao {
	@Select("select * from dept")
	List<CheckOutRecord> showCheckOut();
	@Select("select * from dept")
	List<CheckOutRecord> searchCheckOut(String name);
	@Update("select * from dept")
	Integer checkCheckOut(String checkOutId, Integer state);

}
