package com.winmar.service.data;

import com.winmar.pojo.Data;
import com.winmar.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DataService {
    //根据条件查询用户列表
    public List<Data> getDataList(String querySite, String queryDimension, String queryLongitude, int queryDay,int currentPageNo, int pageSize);


    public List<Data> getDataList1(String querySite, String queryDimension, String queryLongitude, int queryDay,int currentPageNo, int pageSize);

    //查询记录数
    public int getDataCount(String querySite, String queryDimension, String queryLongitude, int queryDay);

    //查询记录数
    public int getDataCount1(String querySite, String queryDimension, String queryLongitude, int queryDay);


//    //通过条件查询-userList
//    public List<Data> getDataList(Connection connection, String site , String dimension, String longitude, int day, int currentPageNo, int pageSize)throws Exception;
//
//    //根据用户名或者角色查询用户总数
//    public int getDataCount(Connection connection, String site , String dimension,String longitude,int day)throws SQLException, Exception;

}
