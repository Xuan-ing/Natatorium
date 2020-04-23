<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 14346
  Date: 2020/4/21
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>办理折扣卡</title>
</head>
<body>
<s:form method="post" action="addDiscountCard">
    <div style="text-align: center;">请缴纳500￥以办理折扣卡，消费享受8折优惠</div>
    <img src="image/pay.jpg" alt="支付二维码"/>
    <br/>
    <div style="text-align: center;">提示：折扣卡会在30天后过期</div>
    <s:submit value="确认办理"/>
</s:form>
</body>
</html>
