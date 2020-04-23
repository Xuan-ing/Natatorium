<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<s:form method="post" action="add">
    手机号：<s:textfield name="tel" />
    密码：<s:password name="password" />
    姓名：<s:textfield name="name" />
    身份证号码：<s:textfield name="no" />
    <s:submit value="注册"/>
</s:form>
</body>
</html>
