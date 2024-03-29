package com.winmar.dao.user;

import com.winmar.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    //增加用户信息
    public int add(Connection connection, User user)throws Exception;

    //得到要登录的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException, Exception;

    //通过条件查询-userList
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)throws Exception;

    //根据用户名或者角色查询用户总数
    public int getUserCount(Connection connection,String username ,int userRole)throws SQLException, Exception;

    //通过userId删除user
    public int deleteUserById(Connection connection, Integer delId)throws Exception;

    //通过userId获取user
    public User getUserById(Connection connection, String id)throws Exception;

    //修改用户信息
    public int modify(Connection connection, User user)throws Exception;

    //修改当前用户密码
    public int updatePwd(Connection connection,String id,String password)throws SQLException, Exception;


}
