package com.neusoft.SP01.dao;

import java.util.List;

import com.neusoft.SP01.po.CustDailyNursingDTO;
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
	@Select("SELECT cir.check_in_record_id as checkInRecordId, " +
	        "c.name as customerName, " +
	        "TIMESTAMPDIFF(YEAR, STR_TO_DATE(SUBSTRING(c.identity, 7, 8), '%Y%m%d'), CURDATE()) as age, " +
	        "c.gender, c.identity, c.blood_type as bloodType, c.tel, " +
	        "f.name as familyName, f.tel as familyTel, " +
	        "r.floor, r.room_number as room, b.bed_number as bed, " +
	        "cir.check_in_time as checkInTime, cir.end_time as endTime " +
	        "FROM t_customer c " +
	        "JOIN t_check_in_record cir ON c.customer_id = cir.customer_id " +
	        "LEFT JOIN t_family f ON c.customer_id = f.customer_id " +  // 这里确保有空格
	        "JOIN t_bed_record br ON cir.check_in_record_id = br.check_in_id AND br.state = 1 " +
	        "JOIN t_bed b ON br.bed_id = b.bed_id " +
	        "JOIN t_room r ON b.room_id = r.room_id " +
	        "WHERE c.type = '0' AND cir.state = 1 " +
	        "LIMIT #{offset}, #{pageSize}")
	List<CustCheckInDTO> showSelfCust(long offset,long pageSize);
	/*计算总数*/
	@Select("SELECT COUNT(*) FROM t_customer c " +
            "JOIN t_check_in_record cir ON c.customer_id = cir.customer_id " +
            "WHERE c.type = '0' AND cir.state = 1")
    long countSelfCareCustomers();
	
	/*查询所有护理老人客户列表*/
	@Select("SELECT cir.check_in_record_id as checkInRecordId, " +
	        "c.name as customerName, " +
	        "TIMESTAMPDIFF(YEAR, STR_TO_DATE(SUBSTRING(c.identity, 7, 8), '%Y%m%d'), CURDATE()) as age, " +
	        "c.gender, c.identity, c.blood_type as bloodType, c.tel, " +
	        "f.name as familyName, f.tel as familyTel, " +
	        "r.floor, r.room_number as room, b.bed_number as bed, " +
	        "cir.check_in_time as checkInTime, cir.end_time as endTime " +
	        "FROM t_customer c " +
	        "JOIN t_check_in_record cir ON c.customer_id = cir.customer_id " +
	        "LEFT JOIN t_family f ON c.customer_id = f.customer_id " +  // 这里确保有空格
	        "JOIN t_bed_record br ON cir.check_in_record_id = br.check_in_id AND br.state = 1 " +
	        "JOIN t_bed b ON br.bed_id = b.bed_id " +
	        "JOIN t_room r ON b.room_id = r.room_id " +
	        "WHERE c.type = '1' AND cir.state = 1 " +
	        "LIMIT #{offset}, #{pageSize}")
	//@Select("select * from dept")
	List<CustCheckInDTO> showCareCust(long offset,long pageSize);
	@Select("SELECT COUNT(*) FROM t_customer c " +
            "JOIN t_check_in_record cir ON c.customer_id = cir.customer_id " +
            "WHERE c.type = '1' AND cir.state = 1")
    long countCareCustomers();
	
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
    @Update("UPDATE ")
    Integer updateContractEndTime(Integer customerId,String newEndTime);
    
    /*逻辑删除*/
    @Update("UPDATE checkInRecord SET state = 1 WHERE customer_id = #{customerId}")
    Integer logicalDeleteCustomer(Integer checkInRecordId);
    
    
    /*查询客户当前使用的床位信息*/
    @Select("SELECT ")
    CustCheckInDTO findCurrentBedByCustomer(Integer customerId);




	/*=============护工模块 显示该护工下的老人 对应请求路径"/user/showUserCust"=========*/
	List<CustDailyNursingDTO> findUserCust(Integer userId);
	//根据老人姓名模糊搜索
	List<CustDailyNursingDTO> findUserCustByName(Integer userId,String name);

}
