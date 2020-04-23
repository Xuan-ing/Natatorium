<%@ page import="entity.card.PrepaidCard" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>存储卡详情</title>
</head>
<body>
<script>
function hintReportLoss()
{
    alert("挂失成功！");
}
function hintReportConsume()
{
    alert("消费成功，注意余额变化！");
}
</script>
    <s:iterator var="curPrepaidCard" value="#session.curPrepaidCard">
        类型：<s:property value="#curPrepaidCard.type"/>
        <br/>
        余额：<s:property value="#curPrepaidCard.balance"/>
        <br/>
        是否可用：<s:property value="#curPrepaidCard.availability"/>
    </s:iterator>
<br/>
<br/>
<br/>
<%  PrepaidCard curPrepaidCard = (PrepaidCard) session.getAttribute("curPrepaidCard");
    if (!curPrepaidCard.getAvailability())  {%>
<div style="text-align: center;">该存储卡已被挂失，请持身份证到办事处解除或补办</div>
<% } else if(curPrepaidCard.getBalance() < 60) { %>
<div style="text-align: center;">余额不足，请充值</div>
<% }else{%>
<label onclick="hintReportConsume()"><a href="<s:url action="consume"/>">刷卡消费</a> </label>
<% }%>

<br/>
<%if (curPrepaidCard.getAvailability())  {%>
<label onclick="hintReportLoss()"><a href="<s:url action="reportLoss"/>">点击挂失</a> </label>
<%}%>




</body>
</html>
