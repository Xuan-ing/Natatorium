<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!-- 左边菜单栏显示-->


<div >
    <ul >
        <li ><a href="personInfo.jsp" target="right" >个人中心</a></li>
        <li ><a href="<s:url action="getCards"/>" target="right"> 卡包管理</a></li>
        <li ><a href="<s:url action="getPrepaidCards"/>" target="right" >充值</a></li>
        <li ><a href="<s:url action="queryRecordsAction"/>" target="right" >查看消费/充值记录</a></li>
        <li ><a href="adminLogin.jsp" target="right" >管理员入口</a></li>
    </ul>
</div>
