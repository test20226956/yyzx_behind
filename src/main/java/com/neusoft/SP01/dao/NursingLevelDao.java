package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.NursingLevel;
import com.neusoft.SP01.po.NursingProject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 对应t_nursing_level
 */
@Mapper
public interface NursingLevelDao {
    //展示所有护理级别
    @Select("select *  from yyzx_st.t_nursing_level")
    List<NursingLevel> findAll();
    // 按照级别名称查询(应该就返回一个查询到的护理级别吧？)
    @Select("select *  from yyzx_st.t_nursing_level where name=#{name}")
    NursingLevel findNursingLevelByName(String name);
    //展示护理级别下所有的项目(应该要多表查询 联合护理项目 返回护理项目)
    List<NursingProject> findNursingProjectInLevel(Integer id);
    //展示护理级别下所有未包括的项目(应该要多表查询 联合护理项目 返回护理项目)
    List<NursingProject> findNursingProjectNotInLevel(Integer id);
    //修改护理级别的状态
    @Update("update yyzx_st.t_nursing_level set state=#{state} where nursing_level_id=#{NursingLevelId}")
    void updateByState(NursingLevel nl);
    //添加护理级别信息
    @Insert("insert into yyzx_st.t_nursing_level values (null,#{name},#{type})")
    void addNursingLevel(NursingLevel nl);

    //删除护理级别(该级别下的项目也应该有相应的操作吧)
    void deleteNursingLevel(Integer id);

}
