<%@ page import="entity.VipUser" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 左边菜单栏显示-->


<div >
    <ul >
        <li ><a href="personInfo.jsp" target="right" >个人中心</a></li>
        <li >
            <%  VipUser vipUser = (VipUser) session.getAttribute("curVipUser");
                if (vipUser == null) {%>
            <a href="<s:url action="getCards"/>" target="right"> 卡包管理</a>
            <% } else {%>
                <a href="<s:url action="getCards"/>" target="right"> 卡包管理</a>
            <% } %>
        </li>
        <li ><a href="consume.jsp" target="right" >充值</a></li>
        <li ><a href="<s:url action="queryRecordsAction"/>" target="right" >消费/充值记录查询</a></li>
    </ul>
</div>
