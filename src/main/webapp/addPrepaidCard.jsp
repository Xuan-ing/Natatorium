<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 14346
  Date: 2020/4/21
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>办理存储卡</title>
</head>
<body>
<s:form method="post" action="addPrepaidCard">
    <center>请缴纳500￥以办理存储卡</center>
    <img src="image/pay.jpg"/>
    <br/>
    <s:submit value="确认办理"/>
</s:form>
</body>
</html>
