package com.winmar.dao.data;

import com.mysql.cj.util.StringUtils;
import com.winmar.dao.BaseDao;
import com.winmar.pojo.Data;
import com.winmar.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataDaoImpl implements DataDao{

    @Override
    public List<Data> getDataList1(Connection connection, String site, String dimension, String longitude, int day, int currentPageNo, int pageSize) throws Exception {
        // TODO Auto-generated method stub
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Data> dataList = new ArrayList<Data>();
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select * from data where year = 2013 ");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(site)){
                sql.append(" and site like ?");
                list.add("%"+site+"%");
            }
            if(!StringUtils.isNullOrEmpty(dimension)){
                sql.append(" and dimension like ?");
                list.add("%"+dimension+"%");
            }
            if(!StringUtils.isNullOrEmpty(longitude)){
                sql.append(" and longitude like ?");
                list.add("%"+longitude+"%");
            }

            if(day > 0){
                sql.append(" and day = ?");
                list.add(day);
            }
            System.out.println("okla");
            //在数据库中，分页显示 limit startIndex，pageSize；总数
            //当前页  (当前页-1)*页面大小
            //0,5	1,0	 01234
            //5,5	5,0	 56789
            //10,5	10,0 10~
            sql.append(" order by Site limit ?,?");//DESC降序
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());

            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
            if(rs!=null){
                System.out.println("这里没错");
            }else{
                System.out.println("就是这里");
            }
            while(rs.next()){
                Data _data = new Data();
//                _user.setId(rs.getString("id"));
//                _user.setUsersName(rs.getString("UsersName"));
//                _user.setUserPassword(rs.getString("pwd"));
//                _user.setUserLevel(rs.getInt("UserLevel"));
//                _user.setRegistrationDate(rs.getDate("RegistrationDate"));
//                _user.setValidTo(rs.getDate("ValidTo"));
//                _user.setEmail(rs.getString("Email"));
//                _user.setUserRoleName(rs.getString("userRoleName"));
//                userList.add(_user);
                _data.setSite(rs.getString("Site"));
                _data.setDimension(rs.getString("Dimension"));
                _data.setLongitude(rs.getString("longitude"));
                _data.setAltitude(rs.getInt("altitude(*10)"));
                _data.setYear(rs.getInt("year"));
                _data.setMonth(rs.getInt("month"));
                _data.setDay(rs.getInt("day"));
                _data.setPre1(rs.getInt("1-6(h)"));
                _data.setPre2(rs.getInt("6-12(h)"));
                _data.setPre3(rs.getInt("12-18(h)"));
                _data.setPre4(rs.getInt("18-24(h)"));
                dataList.add(_data);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return dataList;
    }

    @Override
    public List<Data> getDataList(Connection connection, String site, String dimension, String longitude, int day, int currentPageNo, int pageSize) throws Exception {
        // TODO Auto-generated method stub
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Data> dataList = new ArrayList<Data>();
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select * from level1 where year = 2013 ");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(site)){
                sql.append(" and site like ?");
                list.add("%"+site+"%");
            }
            if(!StringUtils.isNullOrEmpty(dimension)){
                sql.append(" and dimension like ?");
                list.add("%"+dimension+"%");
            }
            if(!StringUtils.isNullOrEmpty(longitude)){
                sql.append(" and longitude like ?");
                list.add("%"+longitude+"%");
            }

            if(day > 0){
                sql.append(" and day = ?");
                list.add(day);
            }
            System.out.println("okla");
            //在数据库中，分页显示 limit startIndex，pageSize；总数
            //当前页  (当前页-1)*页面大小
            //0,5	1,0	 01234
            //5,5	5,0	 56789
            //10,5	10,0 10~
            sql.append(" order by Site limit ?,?");//DESC降序
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());

            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
            if(rs!=null){
                System.out.println("这里没错");
            }else{
                System.out.println("就是这里");
            }
            while(rs.next()){
                Data _data = new Data();
//                _user.setId(rs.getString("id"));
//                _user.setUsersName(rs.getString("UsersName"));
//                _user.setUserPassword(rs.getString("pwd"));
//                _user.setUserLevel(rs.getInt("UserLevel"));
//                _user.setRegistrationDate(rs.getDate("RegistrationDate"));
//                _user.setValidTo(rs.getDate("ValidTo"));
//                _user.setEmail(rs.getString("Email"));
//                _user.setUserRoleName(rs.getString("userRoleName"));
//                userList.add(_user);
                _data.setSite(rs.getString("Site"));
                _data.setDimension(rs.getString("Dimension"));
                _data.setLongitude(rs.getString("longitude"));
                _data.setAltitude(rs.getInt("altitude(*10)"));
                _data.setYear(rs.getInt("year"));
                _data.setMonth(rs.getInt("month"));
                _data.setDay(rs.getInt("day"));
                _data.setPre1(rs.getInt("1-6(h)"));
                _data.setPre2(rs.getInt("6-12(h)"));
                _data.setPre3(rs.getInt("12-18(h)"));
                _data.setPre4(rs.getInt("18-24(h)"));
                dataList.add(_data);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return dataList;
    }

    @Override
    public int getDataCount1(Connection connection, String site, String dimension, String longitude, int day) throws SQLException, Exception {
        // TODO Auto-generated method stub
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;
        System.out.println("验证");
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from data where year=2013 ");
            List<Object> list = new ArrayList<Object>();//存放我们的参数
            System.out.println("1+"+sql.toString());
            if(!StringUtils.isNullOrEmpty(site)){
                sql.append(" and Site like ?");
                list.add("%"+site+"%");
            }
            if(!StringUtils.isNullOrEmpty(dimension)){
                sql.append(" and Dimension like ?");
                list.add("%"+dimension+"%");
            }
            if(!StringUtils.isNullOrEmpty(longitude)){
                sql.append(" and longitude like ?");
                list.add("%"+longitude+"%");
            }

            if(day > 0){
                sql.append(" and day = ?");
                list.add(day);
            }
            System.out.println("2+"+sql.toString());
            //怎么把List 转成数组
            Object[] params = list.toArray();
            //输出最后的完整语句
            System.out.println("DataDaoImpl->getDataCount:"+sql.toString());

            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);

            if(rs.next()) {
                count = rs.getInt("count");//从结果集中获取最终数量

            }
            BaseDao.closeResource(null, pstm, rs);

        }
        return count;
    }


    @Override
    public int getDataCount(Connection connection, String site, String dimension, String longitude, int day) throws SQLException, Exception {
        // TODO Auto-generated method stub
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;
        System.out.println("验证");
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from level1 where year=2013 ");
            List<Object> list = new ArrayList<Object>();//存放我们的参数
            System.out.println("1+"+sql.toString());
            if(!StringUtils.isNullOrEmpty(site)){
                sql.append(" and Site like ?");
                list.add("%"+site+"%");
            }
            if(!StringUtils.isNullOrEmpty(dimension)){
                sql.append(" and Dimension like ?");
                list.add("%"+dimension+"%");
            }
            if(!StringUtils.isNullOrEmpty(longitude)){
                sql.append(" and longitude like ?");
                list.add("%"+longitude+"%");
            }

            if(day > 0){
                sql.append(" and day = ?");
                list.add(day);
            }
            System.out.println("2+"+sql.toString());
            //怎么把List 转成数组
            Object[] params = list.toArray();
            //输出最后的完整语句
            System.out.println("DataDaoImpl->getDataCount:"+sql.toString());

            rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);

            if(rs.next()) {
                count = rs.getInt("count");//从结果集中获取最终数量

            }
            BaseDao.closeResource(null, pstm, rs);

        }
        return count;
    }
}
