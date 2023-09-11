package com.winmar.servlet.user;

import com.winmar.pojo.User;
import com.winmar.service.user.UserService;
import com.winmar.service.user.UserServiceImpl;
import com.winmar.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根

        System.out.println("login ============ " );
        //获取用户名和密码
        String UsersName = req.getParameter("username");
        String pwd = req.getParameter("password");
        //调用service方法，进行用户匹配
        UserService userService = new UserServiceImpl();
        User user = userService.login(UsersName,pwd);
        if(null != user){//登录成功
            //放入session
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            System.out.println(user.getUserLevel());
            req.getSession().setAttribute("userLevel", user.getUserLevel());
            //页面跳转（frame.jsp）
            System.out.println("okokok" );
            resp.sendRedirect("jsp/frame.jsp");
        }else{
            //页面跳转（login.jsp）带出提示信息--转发
            //req.setAttribute("error", "用户名或密码不正确");
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println("<script>alert('用户名或密码错误');</script>");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
