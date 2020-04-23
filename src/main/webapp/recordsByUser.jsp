<%@ page import="entity.VipUser" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%  VipUser vipUser = (VipUser) session.getAttribute("curVipUser");
    if (vipUser == null) {%>
<div style="text-align: center;">请先在上方登录再使用本系统！</div>
<% } else {%>
<html>
<head>
    <title>流水记录</title>
</head>
<body>
<table>

    <caption>流水记录</caption>
    <tr>、
        <th>消费卡号</th>
        <th>类型</th>
        <th>时间</th>
        <th>金额</th>
    </tr>
    <s:iterator var="record" value="#session.usageRecords">
        <tr>
        <td><s:property value="#record.card.id"/></td>
            <s:if test='%{#record.price>0}'>
            <td>充值</td>
            </s:if>
            <s:else>
            <td>消费</td>
            </s:else>
        <td><s:property value="#record.date"/></td>
        <td><s:property value="#record.price"/></td>
    </s:iterator>
</table>
<% } %>
</body>
</html>
