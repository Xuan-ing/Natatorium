<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>折扣卡详情</title>
</head>
<body>

    <s:iterator var="curDiscountCard" value="#session.curDiscountCard">
        类型：<s:property value="#curDiscountCard.type"/>
        <br/>
        折扣率：<s:property value="#curDiscountCard.discountRate"/>
        <br/>
        到期时间：<s:property value="#curDiscountCard.dueDate"/>
        <br/>
        是否可用：<s:property value="#curDiscountCard.availability"/>
        <br/>
    </s:iterator>


</body>
</html>
