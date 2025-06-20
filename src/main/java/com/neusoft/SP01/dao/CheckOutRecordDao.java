package com.neusoft.SP01.dao;

import java.util.List;

import com.neusoft.SP01.po.CustCheckOutDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neusoft.SP01.po.CheckOutRecordWithName;

@Mapper
public interface CheckOutRecordDao {


	/*分页查询退住申请记录*/
	@Select("SELECT r.*, c.name AS customerName " +
            "FROM t_check_out_record r " +
            "LEFT JOIN t_customer c ON r.customer_id = c.customer_id " +
            "ORDER BY r.apply_time DESC " +
            "LIMIT #{offset}, #{pageSize}")
    List<CheckOutRecordWithName> showCheckOut(@Param("offset") long offset, 
                                            @Param("pageSize") long pageSize);
	/*查询退住申请总记录数*/
	@Select("SELECT COUNT(*) FROM t_check_out_record")
    long countCheckOut();
	
	/*分页多条件查询*/
	@Select("<script>" +
            "SELECT r.*, c.name AS customerName " +
            "FROM t_check_out_record r " +
            "LEFT JOIN t_customer c ON r.customer_id = c.customer_id " +
            "<where>" +
            "   <if test='customerName != null and customerName != \"\"'>" +
            "       AND c.name LIKE CONCAT('%', #{customerName}, '%')" +
            "   </if>" +
            "   <if test='state != null'>" +
            "       AND r.state = #{state}" +
            "   </if>" +
            "</where>" +
            "ORDER BY r.apply_time DESC " +
            "LIMIT #{offset}, #{pageSize}" +
            "</script>")
    List<CheckOutRecordWithName> queryByConditions(
            @Param("customerName") String customerName,
            @Param("state") Integer state,
            @Param("offset") long offset,
            @Param("pageSize") long pageSize);

    /*多条件查询总数*/
    @Select("<script>" +
            "SELECT COUNT(*) " +
            "FROM t_check_out_record r " +
            "LEFT JOIN t_customer c ON r.customer_id = c.customer_id " +
            "<where>" +
            "   <if test='customerName != null and customerName != \"\"'>" +
            "       AND c.name LIKE CONCAT('%', #{customerName}, '%')" +
            "   </if>" +
            "   <if test='state != null'>" +
            "       AND r.state = #{state}" +
            "   </if>" +
            "</where>" +
            "</script>")
    long countByConditions(
            @Param("customerName") String customerName,
            @Param("state") Integer state);
    
    /*审核*/
    @Update("UPDATE t_check_out_record " +
            "SET state = #{state}, " +
            "admin_id = #{adminId}, " +
            "examine_time = #{examineTime} " +
            "WHERE check_out_record_id = #{checkOutRecordId}")
    int approveCheckOut(@Param("checkOutRecordId") Integer checkOutRecordId,
                       @Param("state") Integer state,
                       @Param("adminId") Integer adminId,
                       @Param("examineTime") String examineTime);
    
    /*根据退住记录ID获取客户ID*/
    @Select("SELECT customer_id FROM t_check_out_record WHERE check_out_record_id = #{checkOutRecordId}")
    Integer findCustomerIdByCheckOutId(@Param("checkOutRecordId") Integer checkOutRecordId);
	
	
    
    
	
	
    

	/*====护工模块 用户管理退住申请====*/
	//添加用户的退住申请
	@Insert("insert into yyzx_st.t_check_out_record values (null,#{customerId},#{state},#{type},#{applyTime},#{examineTime},#{adminId},#{nurseId},#{reason})")
	void InsertCheckOutRecord(CheckOutRecord cor);
	//查看用户的退住申请记录
	List<CustCheckOutDTO> findCheckOutRecordByCustomerId(Integer customerId);

}
