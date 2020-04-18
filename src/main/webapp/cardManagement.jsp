<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 10313
  Date: 09/04/2020
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="entity.card.Card" %>
<%@ page import="entity.VipUser" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>卡包管理</title>
</head>
<body>
<%  VipUser vipUser = (VipUser) session.getAttribute("vipUser");
    if (vipUser == null) {%>
<center>请先在上方登录再使用本系统！</center>
<% } else { %>
    <table border="1px" cellpadding="0" width="300px">
        <tr>
            <th>id</th>>
            <th>是否可用</th>
            <th>类型</th>
        </tr>
        <%List<Card> cards =(List<Card>) session.getAttribute("cards");%>
        <%for (Card card:cards) {%>
        <tr>
            <td><%=card.getId()%></td>
            <td><%=card.getAvailability()%></td>
            <td><%=card.getType()%>></td>>
        </tr>
        <%}%>
    </table>
    <br />
    <label><a href="addCard.jsp">办理新卡</a> </label>
<% } %>
</body>
</html>
