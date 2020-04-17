<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 10313
  Date: 09/04/2020
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<s:form method="post" action="userLogin">
    手机号：<s:textfield name="username" />
    密码：<s:password name="password" />
    <s:submit name="submit" value="登录"/>

</s:form>
</body>
</html>

