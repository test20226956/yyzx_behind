package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.NursingRecord;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 对应t_nursing_record
 */
@Mapper
public interface NursingRecordDao {
    //展示老人所有的护理记录
    @Select("select * from yyzx_st.t_nursing_record where customer_id=#{customerId}")
    List<NursingRecord> findByCustomerId(Integer customerId);
    //删除老人的护理记录(批量删除)
    void deleteByIds(@Param("ids") List<Integer> ids);
    //搜索护理记录（原型中体现的 名称（record->service->project）和护理时间 多表查 动态sql）
    List<NursingRecord> findByNameAndTime(String name, DateTimeLiteralExpression.DateTime time);

}
