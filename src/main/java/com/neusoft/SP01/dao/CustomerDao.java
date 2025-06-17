package com.neusoft.SP01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neusoft.SP01.po.CustCheckInDTO;

@Mapper
public interface CustomerDao {
	@Select("select * from dept")
	List<CustCheckInDTO> showSelfCust();
	@Select("select * from dept")
	List<CustCheckInDTO> showCareCust();
	@Select("select * from dept")
	List<CustCheckInDTO> searchCust(String name,String checkInTime,String type);
	@Insert("select * from dept")
	Integer addCust(CustCheckInDTO data);
}
