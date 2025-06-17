package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.NursingProject;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 对应 t_nursing_project
 */
@Mapper
public interface NursingProjectDao {
    //展示所有的护理项目
    @Select("select * from yyzx_st.t_nursing_project")
    List<NursingProject> findAllNursingProject();
    //按名称搜索项目（接口文档中，应该还有状态） (服务关注模块中搜索对应的护理项目也可以用)
    List<NursingProject> findNursingProjectByNameAndState(String name, Integer state);
    //添加护理项目
    @Insert("insert into yyzx_st.t_nursing_project values (null,#{state},#{name},#{price},#{period},#{time},#{description})")
    void addNursingProject(NursingProject np);
    //修改项目信息
    @Update("update yyzx_st.t_nursing_project set state=#{state},name=#{name},price=#{price},period=#{period},time=#{time},description=#{description} ")
    void updateNursingProject(NursingProject np);
    //删除项目
    @Delete("delete from yyzx_st.t_nursing_project where nursing_project_id=#{nursing_project_id}")
    void deleteNursingProject(Integer nursingProjectId);

}
