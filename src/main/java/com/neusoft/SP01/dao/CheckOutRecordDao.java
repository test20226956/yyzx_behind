package com.neusoft.SP01.dao;

import java.util.List;

import com.neusoft.SP01.po.CustCheckOutDTO;
import org.apache.ibatis.annotations.Insert;
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

	/*====护工模块 用户管理退住申请====*/
	//添加用户的退住申请
	@Insert("insert into yyzx_st.t_check_out_record values (null,#{customerId},#{state},#{type},#{applyTime},#{examineTime},#{adminId},#{nurseId},#{reason})")
	void InsertCheckOutRecord(CheckOutRecord cor);
	//查看用户的退住申请记录
	List<CustCheckOutDTO> findCheckOutRecordByCustomerId(Integer customerId);

}
