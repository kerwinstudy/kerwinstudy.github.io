package com.winmar.dao.data;

import com.winmar.pojo.Data;
import com.winmar.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface DataDao {
    //通过条件查询-userList
    public List<Data> getDataList(Connection connection, String site , String dimension, String longitude, int day, int currentPageNo, int pageSize)throws Exception;

    //通过条件查询-userList
    public List<Data> getDataList1(Connection connection, String site , String dimension, String longitude, int day, int currentPageNo, int pageSize)throws Exception;


    //根据用户名或者角色查询用户总数
    public int getDataCount(Connection connection, String site , String dimension,String longitude,int day)throws SQLException, Exception;

    //根据用户名或者角色查询用户总数
    public int getDataCount1(Connection connection, String site , String dimension,String longitude,int day)throws SQLException, Exception;

}
