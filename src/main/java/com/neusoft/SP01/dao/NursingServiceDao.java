package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.NursingProject;
import com.neusoft.SP01.po.NursingService;
import com.neusoft.SP01.po.NursingServiceDailyDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 对应表t_nursing_service
 */
@Mapper
public interface NursingServiceDao {
    //显示用户所有的护理项目(对应原型服务关注 所以多表t_nursing_service->t_nursing_project
    // 所以返回要有项目信息还要有对应的服务信息 暂时先void)
    void findNursingServiceProjectByCustomerId(Integer customerId);
    //给客户的护理项目续费(其实对应操作是修改数量和到期时间)
    @Update("update yyzx_st.t_nursing_service set amount=#{amount},end_time=#{endTime}")
    void updateNursingServiceRenewal(Integer nursingServiceId,Integer amount,String endTime);
    //移除客户的护理项目
    @Delete("delete from yyzx_st.t_nursing_service where nursing_service_id=#{nursingServiceId}")
    void deleteNursingServiceById(Integer nursingServiceId);

    //显示用户未购买的护理项目(同上多表 返回项目信息)
    List<NursingProject> findNursingProjectCustomerNotBuy(Integer customerId);
    //给用户添加护理项目（购买护理服务）
    @Insert("insert into yyzx_st.t_nursing_service values (null,#{customerId},#{nursingLevelId},#{nursingProjectId},#{amount},#{purchaseTime},#{endTime})")
    void addNursingService(NursingService ns);


    /*======对应原型护工 日常护理 显示用户的护理服务=====*/
    List<NursingServiceDailyDTO> findNursingServiceByCustomerId(Integer customerId);

    //按项目名字搜索用户的持有的护理服务
    List<NursingServiceDailyDTO> findNursingServiceByName(Integer customerId,String name);
    //对应原型护工 日常护理 添加用户护理记录，相应的对应护理服务的数量也应该减少
    @Update("UPDATE yyzx_st.t_nursing_service SET amount = amount - #{count} WHERE nursing_service_id = #{nursingServiceId}")
    void updateNursingServiceAmount(Integer count,Integer nursingServiceId);
}
