package com.neusoft.SP01.dao;

import com.neusoft.SP01.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 对应 t_user
 */
@Mapper
public interface UserDao {
    //登录
	@Select("SELECT * FROM t_user WHERE account = #{account}")
    User findUserByAccount(String account);
    /*
    用户管理
     */
    //角色列表
    @Select("select * from yyzx_st.t_user where type=#{type}")
    List<User> findUsers(Integer type);
    
    //按编号或者姓名动态查询
    List<User> findUsersByIdAndName(Integer type,Integer userId,String userName);

    //删除护工
    @Delete("delete from yyzx_st.t_user where user_id=#{userId}")
    void deleteUserById(Integer userId);
    
    /*分页查询所有普通用户(type=1)*/
    @Select("SELECT * FROM t_user WHERE type = 1 LIMIT #{offset}, #{pageSize}")
    List<User> findUsersByTypeWithPage(
            @Param("offset") Integer offset,
            @Param("pageSize") Integer pageSize);

    /*统计普通用户数量(type=1)*/
    @Select("SELECT COUNT(*) FROM t_user WHERE type = 1")
    long countUsersByType();
}
