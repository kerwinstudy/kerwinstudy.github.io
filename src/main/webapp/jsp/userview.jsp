<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${requestScope.user.id }</span></p>
            <p><strong>用户名称：</strong><span>${user.usersName }</span></p>
            <p><strong>用户等级：</strong><span>${user.userLevel }</span></p>
            <p><strong>用户邮箱：</strong><span>${user.email }</span></p>
            <p><strong>用户角色：</strong><span>${requestScope.user.userRoleName}</span></p>
			<div class="providerAddBtn">
            	<input type="button" id="back" name="back" value="返回" >
            </div>
        </div>
    </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userview.js" charset="UTF-8"></script>