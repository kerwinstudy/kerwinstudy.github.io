package com.winmar.servlet;

import com.alibaba.fastjson.JSONArray;
import com.winmar.dao.data.DataDaoImpl;
import com.winmar.pojo.Data;
import com.winmar.pojo.Role;
import com.winmar.pojo.User;
import com.winmar.service.data.DataServiceImpl;
import com.winmar.service.role.RoleService;
import com.winmar.service.role.RoleServiceImpl;
import com.winmar.service.user.UserService;
import com.winmar.service.user.UserServiceImpl;
import com.winmar.util.Constants;
import com.winmar.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class data extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        String method = req.getParameter("method");
        if(method.equals( "query") && method != null){
            this.query(req, resp);
        }else if(method.equals( "query1") && method != null){
            this.query1(req, resp);
        }
        // 想添加新的增删改查，直接用if(method != "savepwd" && method != null);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //重点、难点
    private void query(HttpServletRequest req, HttpServletResponse resp) {
        // TODO 自动生成的方法存根
        //查询用户列表
        //从前端获取数据
        //查询用户列表
        //返回前端

        String querySite = req.getParameter("querySite");
        String queryDimension = req.getParameter("queryDimension");
        String queryLongitude = req.getParameter("queryLongitude");
        String queryday = req.getParameter("queryDay");
        String pageIndex = req.getParameter("pageIndex");
        int queryDay = 0;

        //获取用户列表
        DataServiceImpl dataService = new DataServiceImpl();
        List<Data> dataList = null;

        //第一此请求肯定是走第一页，页面大小固定的
        //设置页面容量
        int pageSize = Constants.dataPageSize;;//把它设置在配置文件里,后面方便修改
        //当前页码
        int currentPageNo = 1;

        if(querySite == null){
            querySite = "";
        }
        if(queryDimension == null){
            queryDimension = "";
        }
        if(queryLongitude == null){
            queryLongitude = "";
        }

        if(queryday != null && !queryday.equals("")){
            queryDay = Integer.parseInt(queryday);
        }
        if(pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //获取用户总数（分页	上一页：下一页的情况）
        //总数量（表）
        int totalCount = dataService.getDataCount(querySite, queryDimension, queryLongitude, queryDay);
        System.out.println(totalCount);
        //总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount =pageSupport.getTotalPageCount();//总共有几页
        //(totalCount+pageSize-1/pageSize)取整
        // pageSupport.getTotalCount()

        //System.out.println("totalCount ="+totalCount);
        //System.out.println("pageSize ="+pageSize);
        //System.out.println("totalPageCount ="+totalPageCount);
        //控制首页和尾页
        //如果页面小于 1 就显示第一页的东西
        if(currentPageNo < 1) {
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount) {//如果页面大于了最后一页就显示最后一页
            currentPageNo =totalPageCount;
        }

        dataList = dataService.getDataList(querySite, queryDimension,queryLongitude,queryDay, currentPageNo, pageSize);
        if(dataList!=null){
            System.out.println("有啊有的");
        }else{
            System.out.println("怎么是空的");
        }
        req.setAttribute("dataList", dataList);
//
//        RoleServiceImpl roleService = new RoleServiceImpl();
//        List<Role> roleList = roleService.getRoleList();
//        req.setAttribute("roleList", roleList);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("querySite", querySite);
        req.setAttribute("queryDimension", queryDimension);
        req.setAttribute("queryLongitude", queryLongitude);
        req.setAttribute("queryDay", queryDay);
        try {
            req.getRequestDispatcher("/jsp/datalist.jsp").forward(req, resp);
        } catch (ServletException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    private void query1(HttpServletRequest req, HttpServletResponse resp) {
        // TODO 自动生成的方法存根
        //查询用户列表
        //从前端获取数据
        //查询用户列表
        //返回前端

        String querySite = req.getParameter("querySite");
        String queryDimension = req.getParameter("queryDimension");
        String queryLongitude = req.getParameter("queryLongitude");
        String queryday = req.getParameter("queryDay");
        String pageIndex = req.getParameter("pageIndex");
        int queryDay = 0;

        //获取用户列表
        DataServiceImpl dataService = new DataServiceImpl();
        List<Data> dataList = null;

        //第一此请求肯定是走第一页，页面大小固定的
        //设置页面容量
        int pageSize = Constants.dataPageSize;;//把它设置在配置文件里,后面方便修改
        //当前页码
        int currentPageNo = 1;

        if(querySite == null){
            querySite = "";
        }
        if(queryDimension == null){
            queryDimension = "";
        }
        if(queryLongitude == null){
            queryLongitude = "";
        }

        if(queryday != null && !queryday.equals("")){
            queryDay = Integer.parseInt(queryday);
        }
        if(pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //获取用户总数（分页	上一页：下一页的情况）
        //总数量（表）
        int totalCount = dataService.getDataCount1(querySite, queryDimension, queryLongitude, queryDay);
        System.out.println(totalCount);
        //总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount =pageSupport.getTotalPageCount();//总共有几页
        //(totalCount+pageSize-1/pageSize)取整
        // pageSupport.getTotalCount()

        //System.out.println("totalCount ="+totalCount);
        //System.out.println("pageSize ="+pageSize);
        //System.out.println("totalPageCount ="+totalPageCount);
        //控制首页和尾页
        //如果页面小于 1 就显示第一页的东西
        if(currentPageNo < 1) {
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount) {//如果页面大于了最后一页就显示最后一页
            currentPageNo =totalPageCount;
        }

        dataList = dataService.getDataList1(querySite, queryDimension,queryLongitude,queryDay, currentPageNo, pageSize);
        if(dataList!=null){
            System.out.println("有啊有的");
        }else{
            System.out.println("怎么是空的");
        }
        req.setAttribute("dataList", dataList);
//
//        RoleServiceImpl roleService = new RoleServiceImpl();
//        List<Role> roleList = roleService.getRoleList();
//        req.setAttribute("roleList", roleList);
        req.setAttribute("totalCount", totalCount);
        req.setAttribute("currentPageNo", currentPageNo);
        req.setAttribute("totalPageCount", totalPageCount);
        req.setAttribute("querySite", querySite);
        req.setAttribute("queryDimension", queryDimension);
        req.setAttribute("queryLongitude", queryLongitude);
        req.setAttribute("queryDay", queryDay);
        try {
            req.getRequestDispatcher("/jsp/datalist.jsp").forward(req, resp);
        } catch (ServletException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }
}
