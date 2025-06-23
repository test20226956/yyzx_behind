package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.CustDailyNursingDTO;
import com.neusoft.SP01.po.CustNursingRecordDTO;
import com.neusoft.SP01.po.NursingRecord;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 对应t_nursing_record
 */
@Mapper
public interface NursingRecordDao {
    //展示老人所有的护理记录（护工 健康管家 护理记录）
    List<CustNursingRecordDTO> findByCustomerId(Integer customerId);
    //删除老人的护理记录(批量删除->逻辑删除)
    void deleteByIds(@Param("ids") List<Integer> ids);
    //搜索护理记录（原型中体现的 名称（record->service->project）和护理时间 多表查 动态sql）
    List<CustDailyNursingDTO> findByNameAndTime(Integer customerId,String name, String time);

    //添加老人护理记录
    @Insert("insert into yyzx_st.t_nursing_record values (null,#{nursingServiceId},#{customerId},#{time},#{count},#{userId},1)")
    void addNursingRecord(NursingRecord nr);

}
