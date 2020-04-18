<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="entity.VipUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>卡包管理</title>
</head>
<body>
<%  VipUser vipUser = (VipUser) session.getAttribute("vipUser");
    if (vipUser == null) {%>
<center>请先在上方登录再使用本系统！</center>
<% } else { %>
<script>
    var btn = document.getElementById("btn");
    var flag = 1;
    btn.onclick = function () {
        if(flag == 1) {
            document.getElementById("name").disabled = false;
            document.getElementById("no").disabled = false;
            btn.textContent = "暂时保存";
            flag += 1;
        }else {
            document.getElementById("name").disabled = true;
            document.getElementById("no").disabled = true;
            btn.textContent = "编辑";
            flag -= 1;
        }
    }
</script>
<s:form method="post" action="updatePersonInfo">
    姓名：<s:textfield id="name" name="name" disabled="true" />
    <br/>
    身份证号码：<s:textfield id="no"  name="no" disabled="true"/>
    <br/>
    电话号码：<s:textfield id="tel"  name="tel" disabled="true"/>
    <br/>
    <button id="btn">编辑</button>&nbsp<s:submit name="submit" value="提交"/>
</s:form>
<% } %>
</body>
</html>
