package com.neusoft.SP01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neusoft.SP01.po.CustCheckInDTO;
import com.neusoft.SP01.po.Customer;

@Mapper
public interface CustomerDao {
	/*查询所有自理老人客户列表*/
	@Select("select * from dept")
	List<CustCheckInDTO> showSelfCust();
	
	/*查询所有护理老人客户列表*/
	@Select("select * from dept")
	List<CustCheckInDTO> showCareCust();
	
	/*多条件组合查询客户信息*/
	@Select("select * from dept")
	List<CustCheckInDTO> searchCust(String name,String checkInTime,String type);
	
	/*添加*/
	@Insert("select * from dept")
	Integer addCust(CustCheckInDTO data);
	
	/*更新客户基本信息*/
    @Update("UPDATE customer SET name=#{name}, type=#{type}, gender=#{gender}, " +
            "identity=#{identity}, blood_type=#{bloodType}, tel=#{tel} " +
            "WHERE customer_id = #{customerId}")
    
    Integer updateCustomer(CustCheckInDTO data);
    
    /*更新客户合同到期时间*/
    @Update("UPDATE check_in_record SET end_time = #{newEndTime} " +
            "WHERE customer_id = #{customerId} AND state = 1")
    Integer updateContractEndTime(Integer customerId,String newEndTime);
    
    /*逻辑删除*/
    @Update("UPDATE checkInRecord SET state = 1 WHERE customer_id = #{customerId}")
    Integer logicalDeleteCustomer(Integer checkInRecordId);
    
    
    /*查询客户当前使用的床位信息*/
    @Select("SELECT br.* FROM bed_record br " +
            "JOIN check_in_record cir ON br.check_in_id = cir.check_in_record_id " +
            "WHERE cir.customer_id = #{customerId} AND br.state = 1")
    CustCheckInDTO findCurrentBedByCustomer(Integer customerId);

}
