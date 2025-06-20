package com.neusoft.SP01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neusoft.SP01.po.CheckOutRecordWithName;
import com.neusoft.SP01.po.CustOutRecordDTO;
import com.neusoft.SP01.po.OutRecord;
import com.neusoft.SP01.po.OutRecordWithName;

/**
 * 对应t_out_record
 */
@Mapper
public interface OutRecordDao {
    /*管理员模块*/
	
	/*分页查询外出申请记录*/
	@Select("SELECT r.*, c.name AS customerName " +
            "FROM t_out_record r " +
            "LEFT JOIN t_customer c ON r.customer_id = c.customer_id " +
            "ORDER BY r.apply_time DESC " +
            "LIMIT #{offset}, #{pageSize}")
    List<OutRecordWithName> showGoOut(@Param("offset") long offset, 
                                            @Param("pageSize") long pageSize);
	/*查询外出退住申请总记录数*/
	@Select("SELECT COUNT(*) FROM t_out_record")
    long countGoOut();
	
	/*分页多条件查询*/
	@Select("<script>" +
            "SELECT r.*, c.name AS customerName " +
            "FROM t_out_record r " +
            "LEFT JOIN t_customer c ON r.customer_id = c.customer_id " +
            "<where>" +
            "   <if test='customerName != null and customerName != \"\"'>" +
            "       AND c.name LIKE CONCAT('%', #{customerName}, '%')" +
            "   </if>" +
            "   <if test='state != null'>" +
            "       AND r.state = #{state}" +
            "   </if>" +
            "   <if test='applyTime != null and applyTime != \"\"'>" +
            "       AND r.apply_time >= #{applyTime}" +
            "   </if>" +
            "</where>" +
            "ORDER BY r.apply_time DESC " +
            "LIMIT #{offset}, #{pageSize}" +
            "</script>")
    List<OutRecordWithName> queryByConditions(
            @Param("customerName") String customerName,
            @Param("state") Integer state,
            @Param("applyTime") String applyTime,
            @Param("offset") long offset,
            @Param("pageSize") long pageSize);

    /*多条件查询总数*/
    @Select("<script>" +
            "SELECT COUNT(*) " +
            "FROM t_out_record r " +
            "LEFT JOIN t_customer c ON r.customer_id = c.customer_id " +
            "<where>" +
            "   <if test='customerName != null and customerName != \"\"'>" +
            "       AND c.name LIKE CONCAT('%', #{customerName}, '%')" +
            "   </if>" +
            "   <if test='state != null'>" +
            "       AND r.state = #{state}" +
            "   </if>" +
            "   <if test='applyTime != null and applyTime != \"\"'>" +
            "       AND r.apply_time >= #{applyTime}" +
            "   </if>" +
            "</where>" +
            "</script>")
    long countByConditions(
            @Param("customerName") String customerName,
            @Param("state") Integer state,
            @Param("applyTime") String applyTime);
	
    
    /*
    护工模块下的客户管理外出记录
     */
    //添加用户的外出记录
    @Insert("insert into yyzx_st.t_out_record values (null,#{customerId},#{applyTime},#{examineTime},#{state},#{adminId},#{reason},#{outTime},#{expectedReturnTime},#{nurseId},#{actualReturnTime})")
    void addOutRecord(OutRecord or);
    //根据老人查找对应的外出申请(外出申请功能页面中点击老人的申请记录)（多表查询 t_out_record t_customer）
    List<CustOutRecordDTO> findOutRecordByCustomerId(Integer customerId);
    //给用户添加回院时间
    @Update("update yyzx_st.t_out_record set actual_return_time=#{actualReturnTime} where out_record_id=#{outRecordId}")
    void AddActualReturnTime(Integer outRecordId, String actualReturnTime);




}
