<%@ page import="java.util.Date" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 10313
  Date: 11/04/2020
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>办理新卡</title>
</head>
<body>
<s:form action="addCard">
    <label>新卡的类型：</label>
    <label>
        <select name="cardType">
            <option value="discountCard">折扣卡</option>
            <option value="prepaidCard">储值卡</option>
        </select>
    </label>
    <%
        request.setCharacterEncoding("utf-8");
        String value = request.getParameter("cardType");
        if (value.equals("discountCard")) {
    %>
        Discount: 10% OFF<br />
        Due Date: <%= new Date(365).toString() %>
    <% } else if (value.equals("prepaidCard")) { %>
        Prepaid Amount: <s:textfield name="balance"/>
    <% } %>
    <s:submit name="submit"/>
</s:form>
</body>
</html>
