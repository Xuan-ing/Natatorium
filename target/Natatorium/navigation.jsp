<%--
  Created by IntelliJ IDEA.
  User: 10313
  Date: 10/04/2020
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="entity.VipUser" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<body>
<%  VipUser vipUser = (VipUser) session.getAttribute("curVipUser");
    if (vipUser == null) {%>
<a href="login.jsp">点击登录</a>
<% } else { %>
<s:iterator var="curUser" value="#session.curVipUser">
    欢迎：<s:property value="#curUser.name"/>
</s:iterator>
<br/>
<a href="<s:url action="logout"/>">安全退出</a>
<% } %>
<br />

</body>
</html>
