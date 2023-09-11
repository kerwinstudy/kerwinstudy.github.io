<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<div class="right">
    <img class="wColck" src="/images/clock.jpg" alt=""/>
    <div class="wFont">
        <h2>${sessionScope.userSession.usersName}</h2>
        <p>欢迎来到天气信息管理管理系统!</p>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
