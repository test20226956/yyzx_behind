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
	@Select("SELECT * FROM yyzx_st.t_user WHERE account = #{account}")
    User findUserByAccount(String account);
    /*
    用户管理
     */
    //角色列表
    @Select("select * from yyzx_st.t_user where type=#{type}")
    List<User> findUsers(Integer type);
    //添加
    //@Insert("insert into yyzx_st.t_user where")
    void addUser(User user);
    //编辑
   // @Update("update yyzx_st.t_user set ")
    void updateUser(User user);
    //按编号或者姓名动态查询
    List<User> findUsersByIdAndName(Integer type,Integer userId,String userName);

    //删除护工
    @Delete("delete from yyzx_st.t_user where user_id=#{userId}")
    void deleteUserById(Integer userId);
}
