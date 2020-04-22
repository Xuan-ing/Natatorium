<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 14346
  Date: 2020/4/17
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Records</title>
</head>
<body>
<table>

    <caption>使用记录：</caption>
    <s:iterator var="record" value="#session.usageRecords">
        <tr>
            <td>卡类型：</td>
            <td><s:property value="#record.card.type"/></td>
        </tr>
        <tr>
            <td>记录类型：</td>
            <td><s:property value="#record.type"/> </td>
        </tr>
        <tr>
            <td>时间：</td>
            <td><s:property value="#record.date"/> </td>
        </tr>
        <%--        <s:if test='%{#record.type=="usageRecord"}'>--%>
        <%--            <tr>--%>
        <%--                <td>花费：</td>--%>
        <%--                <td><s:property value="record.balance"/></td>--%>
        <%--            </tr>--%>
        <%--        </s:if>--%>
        <%--        <s:elseif test='%{#record.type=="eventRecord"}'>--%>
        <%--            <tr>--%>
        <%--                <td>记录类型：</td>--%>
        <%--                <td><s:property value="record.eventType"/></td>--%>
        <%--            </tr>--%>
        <%--            <tr>--%>
        <%--                <td>理由：</td>--%>
        <%--                <td><s:property value="record.reason"/> </td>--%>
        <%--            </tr>--%>
        <%--        </s:elseif>--%>
    </s:iterator>
</table>

</body>
</html>
