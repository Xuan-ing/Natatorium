<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 10313
  Date: 09/04/2020
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>卡包管理</title>
</head>
<body>
    <jsp:include page="navigation.jsp"/>
    <s:debug/>
    我的卡包：
    <s:form action="getUserCardList">
        <s:iterator var="cards" value="#session.cards">
            <s:property value="#cards[0].id"/>
            <s:property value="#cards[0].availability"/>
        </s:iterator>
        <br />
        <label><a href="addCard.jsp">办理新卡</a> </label>
    </s:form>
</body>
</html>
