<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script>
    document.addEventListener('DOMContentLoaded', function() {
        var superWeatherLink = document.querySelector('[name="superWeather"]');

        superWeatherLink.addEventListener('click', function(event) {
            event.preventDefault(); // 阻止默认的跳转行为

            var userLevel = '<%= session.getAttribute("userLevel") %>'; // 获取sessionStorage中的用户级别
            if (userLevel == 1) {
                alert('用户权限不足');
            } else if (userLevel == 2) {
                window.location.href = this.getAttribute('href'); // 执行正常的跳转
            }
        });
    });

</script>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>天气信息管理系统</title>
    <link type="text/css" rel="stylesheet" href="/css/style.css" />
    <link type="text/css" rel="stylesheet" href="/css/public.css" />
</head>
<body>
<!--头部-->
<%--fff21b后面--%>
<%--isELIgnored="false"--%>
    <header class="publicHeader">
        <h1>天气信息管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> ${sessionScope.userSession.usersName}</span> , 欢迎你！</p>
            <a href="/jsp/logout.do">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
                 <li ><a href="/jsp/data.do?method=query">天气信息查询</a></li>
              <li><a href="/jsp/data.do?method=query1" name="superWeather">超级天气信息查询</a></li>
              <li><a href="/jsp/user.do?method=query">用户管理</a></li>
              <li><a href="/jsp/pwdmodify.jsp">密码修改</a></li>
              <li><a href="/jsp/logout.do">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>