<%@ page contentType="text/html;charset=UTF-8" language="java" import="entity.VipUser" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>卡包管理</title>
</head>
<body>
<%  VipUser vipUser = (VipUser) session.getAttribute("curVipUser");
    if (vipUser == null) {%>
<div style="text-align: center;">请先在上方登录再使用本系统！</div>
<% } else {%>
    <table>
        <caption>卡包管理</caption>
        <tr>
            <th>id</th>
            <th>是否可用</th>
            <th>类型</th>
            <th>操作</th>

        </tr>
       <s:iterator value="#session.cardList" var="card">
           <tr>
            <td><s:property value="#card.id"/></td>
            <td><s:property value="#card.availability"/></td>
            <td><s:property value="#card.type"/></td>>
            <td>
                <a href="selectDiscountCard.action?id=<s:property value="#card.id"/>">提交修改</a>

            </td>
           </tr>
       </s:iterator>
    </table>
    <br />
    <label><a href="addPrepaidCard.jsp">办理储存卡</a> </label>
    <label><a href="addDiscountCard.jsp">办理折扣卡</a> </label>
<% } %>
</body>
</html>
