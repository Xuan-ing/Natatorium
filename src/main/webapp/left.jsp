<%@ page import="entity.VipUser" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 10313
  Date: 10/04/2020
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 左边菜单栏显示-->
<%  VipUser vipUser = (VipUser) session.getAttribute("curVipUser");
    if (vipUser == null) {%>
<div >
    <ul >
        <li ><a href="personInfo.jsp" target="right" >个人中心</a></li>
        <li ><a href="cardManagement.jsp" target="right">卡包管理</a></li>
        <li ><a href="consume.jsp" target="right" >充值</a></li>
        <li ><a href="record.jsp" target="right" >消费/充值记录查询</a></li>
    </ul>
</div>
<% } else {%>
<div >
    <ul >
        <li ><a href="personInfo.jsp" target="right" >个人中心</a></li>
        <li ><a href="<s:url action="getCards"/>" target="right">卡包管理</a></li>
        <li ><a href="consume.jsp" target="right" >充值</a></li>
        <li ><a href="record.jsp" target="right" >消费/充值记录查询</a></li>
    </ul>
</div>
<% } %>