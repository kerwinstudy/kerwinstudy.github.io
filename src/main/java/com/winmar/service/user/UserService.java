package com.winmar.service.user;

import com.winmar.pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    //增加用户信息
    public boolean add(User user);

    //用户登录
    public User login(String userCode, String userPassword);

    //根据条件查询用户列表
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);

    //查询记录数
    public int getUserCount(String queryUserName, int queryUserRole);

    //根据userCode查询出User
    public User selectUserCodeExist(String userCode);

    //根据ID删除user
    public boolean deleteUserById(Integer delId);

    //根据ID查找user
    public User getUserById(String id);

    //修改用户信息
    public boolean modify(User user);

    //根据用户ID修改密码
    public boolean updatePwd(String id,String password)throws SQLException, Exception;


}
