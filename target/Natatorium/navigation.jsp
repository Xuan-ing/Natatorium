<%@ page import="entity.VipUser" %><%--
  Created by IntelliJ IDEA.
  User: 10313
  Date: 10/04/2020
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<%  VipUser vipUser = (VipUser) session.getAttribute("vipUser");
    if (vipUser == null) {%>
    <a href="login.jsp">登录/注册</a>
<% } else { %>
    <a href="personInfo.jsp">个人中心</a>
    <a href="cardManagement.jsp">卡包管理</a>
    <a href="userManager.jsp">消费记录</a>
<% } %>
</body>
</html>
