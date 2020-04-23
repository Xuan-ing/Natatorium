<%@ page import="entity.VipUser" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>充值中心</title>
</head>
<body>
<%  VipUser vipUser = (VipUser) session.getAttribute("curVipUser");
    if (vipUser == null) {%>
<div style="text-align: center;">请先在上方登录再使用本系统！</div>
<% } else {%>
<script>
    function hintRecharge()
    {
        alert("充值成功！");
    }
</script>
<table>
    <caption>存储卡列表</caption>
    <tr>
        <th>id</th>
        <th>金额</th>
        <th>充值</th>

    </tr>
    <s:iterator value="#session.prepaidCardList" var="prepaidCard">
        <tr>
            <td><s:property value="#prepaidCard.id"/></td>
            <td><s:property value="#prepaidCard.balance"/></td>
            <td>
                <label onclick="hintRecharge()"><a href="recharge.action?id=<s:property value="#prepaidCard.id"/>">充100</a></label>
            </td>
        </tr>
    </s:iterator>
</table>

<% } %>
</body>
</html>
