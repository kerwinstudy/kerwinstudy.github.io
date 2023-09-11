<%--
  Created by IntelliJ IDEA.
  User: 19528
  Date: 2023/6/23
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/jsp/common/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>天气信息页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/jsp/data.do">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>区站号：</span>
            <input name="querySite" class="input-text"	type="text" value="${requestScope.querySite }">

<%--            <span>维度：</span>--%>
<%--            <select name="queryDimension">--%>
<%--                <c:if test="${dataList != null}">--%>
<%--                    <option value="0">--请选择--</option>--%>
<%--                    <c:forEach var="role" items="${requestScope.roleList}">--%>
<%--                        <option <c:if test="${role.userLevel == requestScope.queryUserRole }">selected="selected"</c:if>--%>
<%--                                value="${role.userLevel}">${role.roleName}</option>--%>
<%--                    </c:forEach>--%>
<%--                </c:if>--%>
<%--            </select>--%>
            <span>维度（度分）：</span>
            <input name="queryDimension" class="input-text"	type="text" value="${requestScope.queryDimension }">
            <span>经度（度分）：</span>
            <input name="queryLongitude" class="input-text"	type="text" value="${requestScope.queryLongitude }">
            <span>日期（度分）：</span>
            <input name="queryDay" class="input-text"	type="text" value="${requestScope.queryDay }">

            <input type="hidden" name="pageIndex" value="1"/>
            <input	value="查 询" type="submit" id="searchbutton">

        </form>
    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="7%">区站号</th>
            <th width="8">维度（度分）</th>
            <%--                    <th width="10%">性别</th>--%>
            <%--                    <th width="10%">年龄</th>--%>
            <%--                    <th width="10%">电话</th>--%>
            <th width="8">经度（度分）</th>
            <th width="8%">海拔（米*10）</th>
            <th width="7%">年</th>
            <th width="7%">月</th>
            <th width="7%">日</th>
            <th width="8%">1-6(h)</th>
            <th width="8%">6-12(h)</th>
            <th width="8%">12-18(h)</th>
            <th width="8%">18-24(h)</th>
        </tr>
        <c:forEach var="data" items="${dataList}" varStatus="status">
            <tr>
                <td>
                    <span>${data.site }</span>
                </td>
                <td>
                    <span>${data.dimension }</span>
                </td>
                <td>
                    <span>${data.longitude }</span>
                </td>
                <td>
                    <span>${data.altitude }</span>
                </td>
                <td>
                    <span>${data.year }</span>
                </td>
                <td>
                    <span>${data.month }</span>
                </td>
                <td>
                    <span>${data.day }</span>
                </td>
                <td>
                    <span>${data.pre1 }</span>
                </td>
                <td>
                    <span>${data.pre2 }</span>
                </td>
                <td>
                    <span>${data.pre3 }</span>
                </td>
                <td>
                    <span>${data.pre4 }</span>
                </td>
                    <%--						<td>--%>
                    <%--						<span>${requestScope.user.userName }</span>--%>
                    <%--						</td>--%>
                    <%--						<td>--%>
                    <%--&lt;%&ndash;							<span>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;								<c:if test="${requestScope.user.gender==1}">男</c:if>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;								<c:if test="${user.gender==2}">女</c:if>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;							</span>&ndash;%&gt;--%>
                    <%--						</td>--%>
                    <%--						<td>--%>
                    <%--						<span>${user.age}</span>--%>
                    <%--						</td>--%>
                    <%--						<td>--%>
                    <%--						<span>${user.phone}</span>--%>
                    <%--						</td>--%>
<%--                <td>--%>
<%--                    <span>${user.userRoleName}</span>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <span>${user.registrationDate}</span>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <span>${user.age}</span>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <span>${user.email}</span>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <span><a class="viewUser" href="javascript:;" userid=${requestScope.user.id } username=${requestScope.user.userName }><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>--%>
<%--                    <span><a class="modifyUser" href="javascript:;" userid=${requestScope.user.id } username=${requestScope.user.userName }><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>--%>
<%--                    <span><a class="deleteUser" href="javascript:;" userid=${requestScope.user.id } username=${requestScope.user.userName }><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="totalPageCount" value="${requestScope.totalPageCount}"/>
    <c:import url="rollpage.jsp">
        <c:param name="totalCount" value="${requestScope.totalCount}"/>
        <c:param name="currentPageNo" value="${requestScope.currentPageNo}"/>
        <c:param name="totalPageCount" value="${requestScope.totalPageCount}"/>
    </c:import>
</div>
</section>

<%--<!--点击删除按钮后弹出的页面-->--%>
<%--<div class="zhezhao"></div>--%>
<%--<div class="remove" id="removeUse">--%>
<%--    <div class="removerChid">--%>
<%--        <h2>提示</h2>--%>
<%--        <div class="removeMain">--%>
<%--            <p>你确定要删除该用户吗？</p>--%>
<%--            <a href="#" id="yes">确定</a>--%>
<%--            <a href="#" id="no">取消</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/userlist.js" charset="UTF-8"></script>

