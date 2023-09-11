package com.winmar.service.data;

import com.winmar.dao.BaseDao;
import com.winmar.dao.data.DataDao;
import com.winmar.dao.data.DataDaoImpl;
import com.winmar.dao.user.UserDao;
import com.winmar.dao.user.UserDaoImpl;
import com.winmar.pojo.Data;
import com.winmar.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DataServiceImpl implements DataService{

    private DataDao dataDao;
    public DataServiceImpl(){  dataDao = new DataDaoImpl(); }
    @Override
    public List<Data> getDataList(String querySite, String queryDimension, String queryLongitude, int queryDay,int currentPageNo, int pageSize) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<Data> dataList = null;
        System.out.println("querySite ---- > " + querySite);
        System.out.println("queryDimension ---- > " + queryDimension);
        System.out.println("queryLongitude ---- > " + queryLongitude);
        System.out.println("queryDay ---- > " + queryDay);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            connection = BaseDao.getConnection();
//            System.out.println("又能连上");
            dataList = dataDao.getDataList(connection, querySite,queryDimension,queryLongitude,queryDay,currentPageNo,pageSize);
//            if(dataList!=null){
//                System.out.println("有的有的");
//            }else{
//                System.out.println("没有没有");
//            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return dataList;
    }

    @Override
    public List<Data> getDataList1(String querySite, String queryDimension, String queryLongitude, int queryDay,int currentPageNo, int pageSize) {
        // TODO Auto-generated method stub
        Connection connection = null;
        List<Data> dataList = null;
        System.out.println("querySite ---- > " + querySite);
        System.out.println("queryDimension ---- > " + queryDimension);
        System.out.println("queryLongitude ---- > " + queryLongitude);
        System.out.println("queryDay ---- > " + queryDay);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            connection = BaseDao.getConnection();
//            System.out.println("又能连上");
            dataList = dataDao.getDataList1(connection, querySite,queryDimension,queryLongitude,queryDay,currentPageNo,pageSize);
//            if(dataList!=null){
//                System.out.println("有的有的");
//            }else{
//                System.out.println("没有没有");
//            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        return dataList;
    }

    @Override
    public int getDataCount1(String querySite, String queryDimension, String queryLongitude, int queryDay) {
        // TODO Auto-generated method stub
        Connection connection = null;
        int count = 0;
        System.out.println("querySite ---- > " + querySite);
        System.out.println("queryDimension ---- > " + queryDimension);
        System.out.println("queryLongitude ---- > " + queryLongitude);
        System.out.println("queryDay ---- > " + queryDay);
        try {
            connection = BaseDao.getConnection();
//            if(connection!=null){
//                System.out.println("能连上");
//            }
            count = dataDao.getDataCount1(connection, querySite,queryDimension,queryLongitude,queryDay);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        //System.out.println("count"+count);
        return count;
    }

    @Override
    public int getDataCount(String querySite, String queryDimension, String queryLongitude, int queryDay) {
        // TODO Auto-generated method stub
        Connection connection = null;
        int count = 0;
        System.out.println("querySite ---- > " + querySite);
        System.out.println("queryDimension ---- > " + queryDimension);
        System.out.println("queryLongitude ---- > " + queryLongitude);
        System.out.println("queryDay ---- > " + queryDay);
        try {
            connection = BaseDao.getConnection();
//            if(connection!=null){
//                System.out.println("能连上");
//            }
            count = dataDao.getDataCount(connection, querySite,queryDimension,queryLongitude,queryDay);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            BaseDao.closeResource(connection, null, null);
        }
        //System.out.println("count"+count);
        return count;
    }

}
