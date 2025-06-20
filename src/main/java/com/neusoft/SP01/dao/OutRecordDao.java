package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.CustOutRecordDTO;
import com.neusoft.SP01.po.OutRecord;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 对应t_out_record
 */
@Mapper
public interface OutRecordDao {
    /*
    管理员模块下的外出登录
     */
    //展示所有外出申请(多表查询 t_out_record t_customer 返回信息应该是老人信息+对应的外出记录 这里暂时先void)
    void findOutRecordAndCustomer();
    //根据老人姓名查找对应的外出申请（同上也要多表）
    void findOutRecordAndCustomerByName(String name);

    //对该申请进行审批
    @Update("update yyzx_st.t_out_record set state=#{state} where out_record_id=#{outRecordId}")
    void updateOutRecordState(Integer outRecordId,Integer state);
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
