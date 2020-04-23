<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>adminLogin</title>
</head>
<body>
<s:form method="post" action="adminLogin">
    账号：<s:textfield name="administrator.username" />
    密码：<s:password name="administrator.password" />
    <s:submit name="submit" value="登录"/>
</s:form>
<br/>
<a>想成为管理员？请联系公司内部人员！</a>
</body>
</html>